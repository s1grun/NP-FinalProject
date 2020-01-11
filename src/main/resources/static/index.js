/**
 * Created by weng on 2019/12/18.
 */


var EditingTableId =null;
var AddingLocation = null;
var EditingItemId = null;
var global_Items={
    "test1":{
        "itemid":"test1",
        "content":"11111",
        "locationid":"ChIJ_cZ_332dX0YR9GZKastWFTE",
        "location":"Lidl, Sankt Göransgatan, 斯德哥尔摩瑞典",
        "assignee":"",
        "status":0
    },"test2":{
        "itemid":"test2",
        "content":"2222222",
        "location":"Lidl, Sveavägen, 斯德哥尔摩瑞典",
        "locationid":"ChIJffRzumidX0YRCyHbBTn0_Ls",
        "assignee":"",
        "status":1
    }
};

var USERID = 2;
var USERNAME = "aaa";



$(document).ready(function(){
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems, {'onCloseStart':function () {
        document.getElementById('location_form').innerHTML='';
        document.getElementById('content').value='';
        document.getElementById('location').value='';
        document.getElementById('assignee').value='';
        document.getElementById('location_form2').innerHTML='';
        document.getElementById('content2').value='';
        document.getElementById('location2').value='';
        document.getElementById('assignee2').value='';
        document.getElementById('status').value='';
        var EditingTableId =null;
        var AddingLocation = null;
        var EditingItemId = null;
    }});
    // $('.modal').modal('onCloseStart',);

    new AjaxRequests().getAlLists(USERID,function (data,state) {
        data.map((item,index)=>{
            item.items.map((it,ind)=>{
                global_Items[it.itemid] = it;
                
            })
            render_list(item);
        })
        
        refresh_map();
        console.log(data,state);
    },function (data,state) {
        console.log(data,state);
    })

});




function render_list(oneList){
    var listname = oneList.listname;
    var listid = oneList.listid;
    var col_list = document.getElementById('scroll-list');
    col_list.innerHTML+=`<li class="nav-item">
                                <a class="nav-link" href="#_${listid}">${listname}</a>
                            </li>`;
    var col_content = document.getElementById('todo-content');

    var new_node = document.createElement('div');
    new_node.id=listid;
    new_node.className = 'list-box';
    new_node.innerHTML =`<div id="_${listid}" class="list-box">
                                    <h3>${listname}</h3>
                                    <div class="row">
                                        <!--to do part-->
                                        <div class="col">
                                            <div class="demo-card-square mdl-shadow--2dp ">
                                                <div class="mdl-card__title mdl-card--expand mdl-card--border card-title">
                                                    <h2 class="mdl-card__title-text">todo</h2>
                                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect modal-trigger"  data-target="add-modal"  onclick="openModal('${listid}')">
                                                        add
                                                    </button>
                                                </div>
                                                <div id="${listid}-todo">
                                                    
                                                </div>
                                            </div>

                                        </div>
                                        <!--done part-->
                                        <div class="col">
                                            <div class="demo-card-square mdl-shadow--2dp">
                                                <div class="mdl-card__title mdl-card--expand mdl-card--border">
                                                    <h2 class="mdl-card__title-text">done</h2>
                                                </div>
                                                <div id="${listid}-done"></div>
                                                
                                            </div>
                                        </div>
                                    </div>

                                </div>`;

    // componentHandler.upgradeDom(new_node);
    col_content.appendChild(new_node);
    
    var todoDiv = document.getElementById(`${listid}-todo`);
    var todoHtml = '';
    var doneDiv = document.getElementById(`${listid}-done`);
    var doneHtml = '';
    oneList.items.map((it,ind)=>{
        // console.log(it.status);
        if(it.status==0){
            todoHtml+=`<div class="todo-content mdl-card--border" id="${it.itemid}">
            <label>
                <input type="checkbox" />
                <span class="black-text" onclick="taggleTODO('${it.itemid}')">${it.content}</span><br>
            </label><br>
            <span style="display: inline-block;width: 70%;">location:</span>
            <span href="#!" class="waves-effect waves-green btn-flat modal-trigger" data-target="edit-modal" onclick="EditItem('${it.itemid}')">Edit</span>
        </div>`
        }else{
            doneHtml+=`<div class="todo-content mdl-card--border" id="${it.itemid}">
            <label>
                <input type="checkbox" checked/>
                <span class="black-text" onclick="taggleTODO('${it.itemid}')">${it.content}</span><br>
            </label><br>
            <span style="display: inline-block;width: 70%;">location:</span>
            <span href="#!" class="waves-effect waves-green btn-flat modal-trigger" data-target="edit-modal" onclick="EditItem('${it.itemid}')">Edit</span>
        </div>`;
        }
        
    });
    todoDiv.innerHTML = todoHtml;
    doneDiv.innerHTML = doneHtml;
    
    // componentHandler.upgradeDom(new_node);

}



function taggleTODO(_id){
    
    var state0 = global_Items[_id].status;
    if(state0==0){
        global_Items[_id].status = 1;
    }else{
        global_Items[_id].status = 0;
    }

    new AjaxRequests().updateItem(global_Items[_id],function(data,state){
        console.log(data,state);
    },function(data,state){
        console.log(data,state);
        global_Items[_id].status = state0;
    })
}





window.onload=function () {
    var dialog = document.querySelector('dialog');
    var showDialogButton = document.querySelector('#add-list-btn');
    if (! dialog.showModal) {
        dialogPolyfill.registerDialog(dialog);
    }
    showDialogButton.addEventListener('click', function() {
        dialog.showModal();
    });
    dialog.querySelector('.close-btn').addEventListener('click', function() {
        dialog.close();
    });
    document.getElementById("approve-btn").addEventListener('click',function () {
       var listname =  document.getElementById('list_name_input').value;
       if(listname!=''){
           new AjaxRequests().addList({listname:listname, owner:USERID},function (data,state) {
               console.log(data,data.status);
               dialog.close();
               if(data.status==200){
                   var listid = data.listid;
                   var col_list = document.getElementById('scroll-list');
                   col_list.innerHTML+=`<li class="nav-item">
                                        <a class="nav-link" href="#_${listid}">${listname}</a>
                                    </li>`;
                   var col_content = document.getElementById('todo-content');

                   var new_node = document.createElement('div');
                   new_node.id=listid;
                   new_node.className = 'list-box';
                   new_node.innerHTML =`<div id="_${listid}" class="list-box">
                                    <h3>${listname}</h3>
                                    <div class="row">
                                        <!--to do part-->
                                        <div class="col">
                                            <div class="demo-card-square mdl-shadow--2dp ">
                                                <div class="mdl-card__title mdl-card--expand mdl-card--border card-title">
                                                    <h2 class="mdl-card__title-text">todo</h2>
                                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect modal-trigger"  data-target="add-modal"  onclick="openModal(${listid})">
                                                        add
                                                    </button>
                                                </div>
                                                <div id="${listid}-todo">
                                                    
                                                </div>
                                            </div>

                                        </div>
                                        <!--done part-->
                                        <div class="col">
                                            <div class="demo-card-square mdl-shadow--2dp">
                                                <div class="mdl-card__title mdl-card--expand mdl-card--border">
                                                    <h2 class="mdl-card__title-text">done</h2>
                                                </div>
                                                <div id="${listid}-done"></div>
                                                
                                            </div>
                                        </div>
                                    </div>

                                </div>`;

                   col_content.appendChild(new_node);
                   //    componentHandler.upgradeDom(new_node);
                   document.getElementById('list_name_input').value ='';

               }else{
                   M.toast({html: '<p style="color:blue">Listname already exists</p>'})
               }
           },function (data,state) {
               console.log(data,state);
               dialog.close();
               M.toast({html: '<p style="color:red">Oooops! Please connect to internet</p>'})
           });
       }else{
           dialog.close();
           M.toast({html: '<p style="color:red">Listname Required</p>'})
       }


    })
}

function openModal(listId) {
    // var elem = document.getElementById('add-modal');
    // var instance1 = M.Modal.getInstance(elem);
    // instance1.open();
    EditingTableId=listId;
}



function EditItem(itemId) {
    EditingItemId = itemId;
    for (var id in global_Items){
        if(id==itemId){
            var it = global_Items[id];
            document.getElementById('content2').value = it.content;
            document.getElementById('status').value = it.status;
            document.getElementById('location2').value = it.location;
            document.getElementById('assignee2').value = it.assignee;
            M.updateTextFields();
            break;
        }
    }
}

function ConfirmEdit() {

}

function AddItem() {
    var tid = EditingTableId;
    var req = {
        "listid":tid,
        "content":document.getElementById("content").value,
        "location":AddingLocation.location,
        "locationid":AddingLocation.locationid,
        "assignee":document.getElementById("assignee").value,
        "status":0
    }
    new AjaxRequests().addItem(req,function(data,state){
        console.log(data,state);
        $('.modal').modal('close');
    },function (data,state) {
        console.log(data,state);
    })

}

function re_renderOneList(tid){

    var todo = document.getElementById(tid+"-todo");
    todo.innerHTML='';
    todo+=`<div class="todo-content mdl-card--border" id="${itemId}">
                                                        <label>
                                                            <input type="checkbox" />
                                                            <span class="black-text">todotodotodo todo todo todotodotodotodotodot odotodotodotod otodo todoto dotodo</span><br>
                                                        </label>
                                                        <span style="display: inline-block;width: 70%;">location:</span>
                                                        <span href="#!" class="waves-effect waves-green btn-flat" onclick="EditItem('${itemId}')">Edit</span>
                                                    </div>`;
}