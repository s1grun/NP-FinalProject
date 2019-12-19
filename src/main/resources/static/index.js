/**
 * Created by weng on 2019/12/18.
 */


var EditingTableId =null;
var AddingLocation = null;
var EditingItemId = null;
var global_Items={
    "test1":{
        "listid":"test1",
        "content":"11111",
        "locationid":"ChIJ_cZ_332dX0YR9GZKastWFTE",
        "location":"Lidl, Sankt Göransgatan, 斯德哥尔摩瑞典",
        "assignee":"",
        "status":0
    },"test2":{
        "listid":"test2",
        "content":"2222222",
        "location":"Lidl, Sveavägen, 斯德哥尔摩瑞典",
        "locationid":"ChIJffRzumidX0YRCyHbBTn0_Ls",
        "assignee":"",
        "status":1
    }
};




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
});

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
       var itemname =listname;
       if(listname!=''){
           var col_list = document.getElementById('scroll-list');
           col_list.innerHTML+=`<li class="nav-item">
                                        <a class="nav-link" href="#${listname}">${listname}</a>
                                    </li>`;
           var col_content = document.getElementById('todo-content');

           var new_node = document.createElement('div');
           new_node.id=listname;
           new_node.className = 'list-box';
           new_node.innerHTML =`<div id="${listname}" class="list-box">
                                    <h3>${listname}</h3>
                                    <div class="row">
                                        <!--to do part-->
                                        <div class="col">
                                            <div class="demo-card-square mdl-shadow--2dp ">
                                                <div class="mdl-card__title mdl-card--expand mdl-card--border card-title">
                                                    <h2 class="mdl-card__title-text">todo</h2>
                                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect modal-trigger"  data-target="add-modal"  onclick="openModal(${listname})">
                                                        add
                                                    </button>
                                                </div>
                                                <div id="${listname}-todo">
                                                    <div class="todo-content mdl-card--border" id="${itemId}">
                                                        <label>
                                                            <input type="checkbox" />
                                                            <span class="black-text">todotodotodo todo todo todotodotodotodotodot odotodotodotod otodo todoto dotodo</span><br>
                                                        </label>
                                                        <span style="display: inline-block;width: 70%;">location:</span>
                                                        <span href="#!" class="waves-effect waves-green btn-flat modal-trigger" data-target="edit-modal" onclick="EditItem('${itemId}')">Edit</span>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <!--done part-->
                                        <div class="col">
                                            <div class="demo-card-square mdl-shadow--2dp">
                                                <div class="mdl-card__title mdl-card--expand mdl-card--border">
                                                    <h2 class="mdl-card__title-text">done</h2>
                                                </div>
                                                <div id="${listname}-done"></div>
                                                
                                            </div>
                                        </div>
                                    </div>

                                </div>`;
           componentHandler.upgradeDom(new_node);
           col_content.appendChild(new_node);
           document.getElementById('list_name_input').value ='';
           dialog.close();

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
        "content":document.getElementById("content"),
        "location":AddingLocation.location,
        "locationid":AddingLocation.locationid,
        "assignee":document.getElementById("assignee"),
        "status":0
    }

}

function renderList(tid){

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