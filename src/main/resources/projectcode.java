
group : Sigrún Arna Sigurðardóttir and Qingtao Weng

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.blue-yellow.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>



    <script src="network.js"></script>
    <script src="index.js"></script>
    <script src="map.js"></script>
    <style>
        /*ul.nav-pills {*/
            /*top: 20px;*/
            /*position: fixed;*/
        /*}*/
        .list-box{
            min-height: 300px;
        }
        .title{
            height: 30px;
            vertical-align: middle;
            line-height:30px;
        }
        .todo-content{
            color: rgba(0,0,0,.54);
            font-size: 1rem;
            line-height: 18px;
            /* overflow: hidden; */
            padding: 16px;
        /* width: 90%;*/
            }
        .todo-item{
            height: 100%;
        }
        .mdl-card--border{
            border-bottom: 1px solid rgba(0,0,0,.1);
        }
        .card-title{
            display: flex;
            justify-content: space-between;
        }
        .black-text{
            color:black;
        }
        #add-list-btn{
            position: fixed;
            bottom: 30px;
        }
        </style>
</head>
<body>

<!-- Simple header with fixed tabs. -->
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header
            mdl-layout--fixed-tabs">
    <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title" id="username">Username</span>
            <a class="waves-effect waves-light btn" style="margin-left: 50px; " onclick="logout()">logout</a>
        </div>
        <!-- Tabs -->
        <div class="mdl-layout__tab-bar mdl-js-ripple-effect">
            <a href="#fixed-tab-1" class="mdl-layout__tab is-active">TODO</a>
            <a href="#fixed-tab-2" class="mdl-layout__tab">Map</a>
            <!--<a href="#fixed-tab-3" class="mdl-layout__tab">Tab 3</a>-->
        </div>
    </header>
    <!--<div class="mdl-layout__drawer">-->
        <!--<span class="mdl-layout-title">Title</span>-->
    <!--</div>-->
    <main class="mdl-layout__content" >

        <section class="mdl-layout__tab-panel is-active"  id="fixed-tab-1">
                <div class="page-content">
                    <!-- first part-->
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-3 col-4"></div>
                            <div class="col-sm-9 col-8">
                                <div class="row title">
                                    <div class="col-6"><h3> </h3></div>
                                    <div class="col-6"><h3> </h3></div>
                                </div>

                            </div>
                        </div>
                        <div class="row">
                            <ul class="col-sm-3 col-4" id="myScrollspy" style="position: relative">
                                <ul class="nav nav-pills flex-column" id="scroll-list">
                                    <!-- <li class="nav-item">
                                        <a class="nav-link active" href="#a1">Section 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#section2">Section 2</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#section3">Section 3</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Section 4</a>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="#section41">Link 1</a>
                                            <a class="dropdown-item" href="#section42">Link 2</a>
                                        </div>
                                    </li> -->
                                </ul>
                                <!-- FAB button with ripple -->
                                <button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect "  id="add-list-btn">
                                    <i class="material-icons ">add</i>
                                </button>

                            </ul>
                            <div class="col-sm-9 col-8" data-spy="scroll"  data-target="#myScrollspy" data-offset="1" style="height: 500px;overflow: scroll;" id="todo-content">

                                <!-- <div id="a1" class="list-box">
                                    <h3>section1</h3>
                                    <div class="row">

                                        <div class="col">
                                            <div class="demo-card-square mdl-shadow--2dp">
                                                <div class="mdl-card__title mdl-card--expand mdl-card--border card-title">
                                                    <h2 class="mdl-card__title-text">todo</h2>

                                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect modal-trigger" data-target="add-modal" onclick="openModal('section1')">
                                                        add
                                                    </button>

                                                </div>
                                                <div id="section1-todo">
                                                    <div class="todo-content mdl-card--border">
                                                        <label>
                                                            <input type="checkbox" />
                                                            <span class="black-text">aaa</span><br>

                                                        </label><br>
                                                        <span style="display: inline-block;width: 70%;">location:</span>
                                                        <span href="#!" class="waves-effect waves-green btn-flat modal-trigger" data-target="edit-modal" onclick="EditItem('test2')">Edit</span>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="col">
                                            <div class="demo-card-square mdl-shadow--2dp">
                                                <div class="mdl-card__title mdl-card--expand mdl-card--border">
                                                    <h2 class="mdl-card__title-text">done</h2>
                                                </div>
                                                <div id="section1-done">
                                                    <div class="todo-content mdl-card--border">
                                                        <label>
                                                            <input type="checkbox" checked/>
                                                            <span class="black-text">todotodotodo todo todo todotodotodotodotodot odotodotodotod otodo todoto dotodo</span><br>
                                                        </label>
                                                        <span style="display: inline-block;width: 70%;">location:</span>
                                                        <span href="#!" class="waves-effect waves-green btn-flat" onclick="EditItem()">Edit</span>
                                                    </div>
                                                    <div class="todo-content mdl-card--border">
                                                        <label>
                                                            <input type="checkbox" checked/>
                                                            <span class="black-text">todotodotodo todo todo todotodotodotodotodot odotodotodotod otodo todoto dotodo</span><br>

                                                        </label>
                                                        <span style="display: inline-block;width: 70%;">location:</span>
                                                        <span href="#!" class="waves-effect waves-green btn-flat modal-trigger" data-target="edit-modal" onclick="EditItem()">Edit</span>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div id="section2" class="list-box">
                                    <h1>Section 2</h1>
                                    <p>Try to scroll this section and look at the navigation list while scrolling!</p>
                                </div>
                                <div id="section3" class="list-box">
                                    <h1>Section 3</h1>
                                    <p>Try to scroll this section and look at the navigation list while scrolling!</p>
                                </div>
                                <div id="section41" class="list-box">
                                    <h1>Section 4-1</h1>
                                    <p>Try to scroll this section and look at the navigation list while scrolling!</p>
                                </div>
                                <div id="section42" class="list-box">
                                    <h1>Section 4-2</h1>
                                    <p>Try to scroll this section and look at the navigation list while scrolling!</p>
                                </div> -->
                            </div>
                        </div>
                    </div>



                </div>
            </section>


        <section class="mdl-layout__tab-panel" id="fixed-tab-2">
            <div class="page-content"><!-- Your content goes here -->
                <div class="container" id="map" style="height: 500px; margin-top: 20px;">

                </div>
            </div>
        </section>

    </main>
</div>








<!--dialog-->
<dialog class="mdl-dialog">
    <h4 class="mdl-dialog__title" id="dialog-title">Add list</h4>
    <div class="mdl-dialog__content" id="dialog-content">
        <!-- Textfield with Floating Label -->

        <form action="#">
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input class="mdl-textfield__input" type="text" id="list_name_input">
                <label class="mdl-textfield__label" for="list_name_input">list name</label>
            </div>
            <!--<div class="mdl-textfield mdl-js-textfield mdl-textfield&#45;&#45;floating-label">-->
                <!--<input class="mdl-textfield__input" type="text" id="list_name_input2">-->
                <!--<label class="mdl-textfield__label" for="list_name_input2">List name</label>-->
            <!--</div>-->
        </form>

    </div>
    <div class="mdl-dialog__actions">
        <button class="mdl-button mdl-js-button mdl-button--primary" id="approve-btn">
            Create
        </button>
        <button class="mdl-button mdl-js-button close-btn">
            Cancel
        </button>
    </div>
</dialog>



<div id="add-modal" class="modal" style="width: 50%; height: auto">
    <div class="modal-content">
        <h4>Add TODO to the list</h4>
        <div class="input-field col s6">
            <input id="content" type="text" class="validate">
            <label for="content">TODO content</label>
        </div>
<!--        <div class="input-field col s6">-->
<!--            <input id="assignee" type="text" class="validate">-->
<!--            <label for="assignee">assignee</label>-->
<!--        </div>-->
        <div class="input-field col s6">
            <input id="location" type="text" class="validate">
            <label for="location">location</label>
        </div>
        <div id="location-list" style="width: 100%;height: 150px;overflow: auto">
            <form action="#" id="location_form">

            </form>
        </div>
    </div>
    <div class="modal-footer">
        <span href="#!" class="modal-close waves-effect waves-red btn-flat" style="color: orangered">Cancel</span>
        <span href="#!" class="waves-effect waves-green btn-flat" onclick="AddItem()">Add</span>
    </div>
</div>





<div id="edit-modal" class="modal" style="width: 50%; height: 95%">
    <div class="modal-content">
        <h4>Edit item</h4>
        <div class="input-field col s6">
            <input id="content2" type="text" class="validate">
            <label class="active"  for="content2">TODO content</label>
        </div>
<!--        <div class="input-field col s6">-->
<!--            <input id="assignee2" type="text" class="validate">-->
<!--            <label class="active"  for="assignee2">assignee</label>-->
<!--        </div>-->

        <div class="input-field col s6">
            <input id="status" type="number" class="validate">
            <label class="active"  for="status">status</label>
        </div>
        <div class="input-field col s6">
            <input id="location2" type="text" class="validate">
            <label class="active" for="location2">location</label>
        </div>
        <div id="location-list2" style="width: 100%;height: 150px;overflow: auto">
            <form action="#" id="location_form2">

            </form>
        </div>
    </div>
    <div class="modal-footer">
        <span href="#!" class="waves-effect waves-green btn-flat left-button" style="color: darkred" onclick="deleteItem()">Delete</span>
        <span href="#!" class="modal-close waves-effect waves-red btn-flat" style="color: orangered">Cancel</span>
        <span href="#!" class="waves-effect waves-green btn-flat" onclick="ConfirmEdit()">Confirm</span>
    </div>
</div>
</body>


<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD30v9VSwmNEwGn_SlC14ZnJ3LBM2Lq5-k&libraries=places&callback=init_autocomplete"
        type="text/javascript"></script>
</html>


/**
 * Created by weng on 2019/12/18.
 */


var EditingTableId =null;
var AddingLocation = null;
var EditingItemId = null;
var global_Items={
    // "test1":{
    //     "itemid":"test1",
    //     "content":"11111",
    //     "locationid":"ChIJ_cZ_332dX0YR9GZKastWFTE",
    //     "location":"Lidl, Sankt Göransgatan, 斯德哥尔摩瑞典",
    //     "assignee":"",
    //     "status":0
    // },"test2":{
    //     "itemid":"test2",
    //     "content":"2222222",
    //     "location":"Lidl, Sveavägen, 斯德哥尔摩瑞典",
    //     "locationid":"ChIJffRzumidX0YRCyHbBTn0_Ls",
    //     "assignee":"",
    //     "status":1
    // }
};
var locations={};


var USERID = $.cookie('userid');
var USERNAME = $.cookie('username');

function logout(){
    $.removeCookie('userid', { path: '/' });
    $.removeCookie('username', { path: '/' });
    window.location.href = 'login.html';
}


$(document).ready(function(){

    if(USERID==undefined || USERNAME==undefined || USERNAME==null || USERID==null ){
        window.location.href = 'login.html';
    }
    document.getElementById("username").innerText = USERNAME;
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems, {'onCloseStart':function () {
        document.getElementById('location_form').innerHTML='';
        document.getElementById('content').value='';
        document.getElementById('location').value='';
        // document.getElementById('assignee').value='';
        document.getElementById('location_form2').innerHTML='';
        document.getElementById('content2').value='';
        document.getElementById('location2').value='';
        // document.getElementById('assignee2').value='';
        document.getElementById('status').value='';
        var EditingTableId =null;
        var AddingLocation = null;
        var EditingItemId = null;
    }});
    // $('.modal').modal('onCloseStart',);

    new AjaxRequests().getAlLists(USERID,function (data,state) {
        if(data.status==200){
            data.locations.map((it,id)=>{
                locations[it.locationid]=it;
            });
            data.data.map((item,index)=>{
                item.items.map((it,ind)=>{
                    global_Items[it.itemid] = it;
                });
                render_list(item);
            })

            refresh_map();
        }

        console.log(data,state);
    },function (data,state) {
        console.log(data,state);
    })

});




function render_list(oneList){
    var listname = oneList.listname;
    var listid = oneList.listid;
    var col_list = document.getElementById('scroll-list');
    col_list.innerHTML+=`<li class="nav-item" id="nav_${listid}">
                                <a class="nav-link" href="#_${listid}">${listname}</a>
                            </li>`;
    var col_content = document.getElementById('todo-content');

    var new_node = document.createElement('div');
    // new_node.id=listid;
    new_node.className = 'list-box';
    new_node.innerHTML =`<div id="_${listid}" class="list-box">
                                    <h3>${listname}</h3><button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"   onclick="deleteList('${listid}')">
                                                        delete
                                                    </button>
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

    renderOneListItems(oneList);

    // componentHandler.upgradeDom(new_node);

}


function renderOneListItems(oneList) {
    var listid = oneList.listid;
    var todoDiv = document.getElementById(`${listid}-todo`);
    var todoHtml = '';
    var doneDiv = document.getElementById(`${listid}-done`);
    var doneHtml = '';
    oneList.items.map((it,ind)=>{
        // console.log(it.status);
        if(it.status==0){
            todoHtml+=`<div class="todo-content mdl-card--border" id="item${it.itemid}">
            <label>
                <input type="checkbox" />
                <span class="black-text" onclick="taggleTODO('${it.itemid}')">${it.content}</span><br>
            </label><br>
            ${it.locationid!=undefined && locations[it.locationid]!=undefined?'<span style="display: inline-block;width: 70%; overflow: hidden">location:'+ locations[it.locationid].name +'</span>':''}
            <span href="#!" class="waves-effect waves-green btn-flat modal-trigger" data-target="edit-modal" onclick="EditItem('${it.itemid}')">Edit</span>
        </div>`
        }else{
            doneHtml+=`<div class="todo-content mdl-card--border" id="item${it.itemid}">
            <label>
                <input type="checkbox" checked/>
                <span class="black-text" onclick="taggleTODO('${it.itemid}')">${it.content}</span><br>
            </label><br>
           ${it.locationid!=undefined && locations[it.locationid]!=undefined?'<span style="display: inline-block;width: 70%; overflow: hidden">location:'+ locations[it.locationid].name +'</span>':''}
            <span href="#!" class="waves-effect waves-green btn-flat modal-trigger" data-target="edit-modal" onclick="EditItem('${it.itemid}')">Edit</span>
        </div>`;
        }

    });
    todoDiv.innerHTML = todoHtml;
    doneDiv.innerHTML = doneHtml;
}

function deleteList(listid) {
    new AjaxRequests().deleteList({listid:listid},function (data,state) {
        console.log(data,state);
        if(data.status!=500){
            M.toast({html: '<p style="color:blue">delete '+data.msg+'</p>'});
            document.getElementById("_"+listid).parentNode.style.display="none";
            document.getElementById("nav_"+listid).style.display="none";

            for(var it in global_Items){
                if(it.listid == listid){
                    delete global_Items[it];
                }
            }
            refresh_map();
        }else{
            M.toast({html: '<p style="color:red">'+data.msg+'</p>'});
        }
    },function (data,state) {
        console.log(data,state);
        M.toast({html: '<p style="color:red"> No internet connection!</p>'});
    })
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
        if(data.status!=500){
            data.locations.map((it,id)=>{
                locations[it.locationid]=it;
            });
            renderOneListItems({listid:data.listid,items:data.data});
        }else{
            M.toast({html: '<p style="color:red">'+data.msg+'</p>'});
            global_Items[_id].status = state0;
        }


    },function(data,state){
        console.log(data,state);
        global_Items[_id].status = state0;
        M.toast({html: '<p style="color:red">Oooops! Please connect to internet</p>'})
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
               if(data.status!=500){
                   var listid = data.listid;
                   var col_list = document.getElementById('scroll-list');
                   col_list.innerHTML+=`<li class="nav-item" id="nav_${listid}">
                                        <a class="nav-link" href="#_${listid}">${listname}</a>
                                    </li>`;
                   var col_content = document.getElementById('todo-content');

                   var new_node = document.createElement('div');
                   // new_node.id=listid;
                   new_node.className = 'list-box';
                   new_node.innerHTML =`<div id="_${listid}" class="list-box">
                                    <h3>${listname}</h3><button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"   onclick="deleteList('${listid}')">
                                                        delete
                                                    </button>
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
            document.getElementById('location2').value = locations[it.locationid] == undefined?"":locations[it.locationid].name ;

            M.updateTextFields();
            break;
        }
    }
}

function ConfirmEdit() {
    var newItem = JSON.parse(JSON.stringify(global_Items[EditingItemId]));

    if(AddingLocation!=null){
        newItem.locationid =AddingLocation.locationid;
    }
    newItem.status = document.getElementById("status").value;
    newItem.content = document.getElementById("content2").value;

    if(newItem.content.trim()==''){
        M.toast({html: '<p style="color:red">Oooops! content cannot be empty</p>'});
        return;
    }
    if(newItem.status!=0 &&newItem.status!=1 ){
        M.toast({html: '<p style="color:red">status should be either 1 or 0</p>'});
        return;
    }
    new AjaxRequests().updateItem(newItem,function(data,state){
        console.log(data,state);
        if(data.status!=500){
            data.locations.map((it,id)=>{
                locations[it.locationid]=it;
            });
            renderOneListItems({listid:data.listid,items:data.data});
            global_Items[EditingItemId] = newItem;
            refresh_map();
            if(data.status==201){
                M.toast({html: '<p style="color:red">'+data.msg+'</p>'});
            }
        }else{
            M.toast({html: '<p style="color:red">'+data.msg+'</p>'});

        }

    },function(data,state){
        console.log(data,state);
        M.toast({html: '<p style="color:red">Oooops! Please connect to internet</p>'})
    });
    AddingLocation=null;
    $('.modal').modal('close');

}

function deleteItem() {
    new AjaxRequests().deleteItem({itemid: parseInt(EditingItemId)},function(data,state){
        console.log(data,state);
        if(data.status!=500){
            M.toast({html: '<p style="color:blue">delete '+data.msg+'</p>'});
            document.getElementById("item"+EditingItemId).style.display="none";
            delete global_Items[EditingItemId];
            refresh_map();
        }else{
            M.toast({html: '<p style="color:red">'+data.msg+'</p>'});
        }
    },function(data,state){
        console.log(data,state);
        M.toast({html: '<p style="color:red">Oooops! Please connect to internet</p>'})
    });
    AddingLocation=null;
    $('.modal').modal('close');
}



function AddItem() {
    var tid = EditingTableId;
    var req = {
        "listid":tid,
        "content":document.getElementById("content").value,

        // "assignee":document.getElementById("assignee").value,
        "status":0
    };
    if(AddingLocation!=null){
        req.locationid = AddingLocation.locationid;
    }
    if(req.content.trim()==''){
        M.toast({html: '<p style="color:red">Oooops! content cannot be empty</p>'});
        return;
    }
    new AjaxRequests().addItem(req,function(data,state){
        console.log(data,state);
        $('.modal').modal('close');
        if(data.status==200 || data.status==201){
            data.locations.map((it,id)=>{
                locations[it.locationid]=it;
            });
            renderOneListItems({listid:tid,items:data.data});
            AddingLocation = null;
            data.data.map((item,index)=>{
                global_Items[item.itemid] = item;
            })
            refresh_map();
            if(data.status==201){
                M.toast({html: '<p style="color:red">'+data.msg+'</p>'})
            }
        }
    },function (data,state) {
        console.log(data,state);
        M.toast({html: '<p style="color:red">Oooops! Please connect to internet</p>'})
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

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>login</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

    <script src="network.js"></script>
</head>
<body>
    <h3>login</h3>
    <input type="text" name="username" id="username" placeholder="username">
    <input type="password" name="password" id="password" placeholder="password">
    <button onclick="login()">login</button>
    <h3>register</h3>
    <input type="text" name="username" id="username2" placeholder="username">
    <input type="password" name="password" id="password2" placeholder="password">
    <button onclick="register()">register</button>
</body>
<script>
    function login() {
        var username = document.getElementById('username').value.trim();
        var password = document.getElementById('password').value.trim();
        new AjaxRequests().login({username,password},function(data,state){
                console.log(data,state);
                if(data.status==200){
                    $.cookie('username',data.username,{ path: '/' });
                    $.cookie('userid',data.userid,{ path: '/' });
                    window.location.href='/';
                }else{
                    alert('username or password is not correct');
                }
            },function(){
                alert('net work err');
            }
        )
    }


    function register() {
        var username = document.getElementById('username2').value.trim();
        var password = document.getElementById('password2').value.trim();
        if(username=="" || password==""){
            alert('username or password cannot be empty');
            return;
        }else{
            new AjaxRequests().register({username,password},function(data,state){
                    console.log(data,state);
                    if(data.status==200){
                        alert('register successfully')
                    }else{
                        alert('username already exists');
                    }
                },function(){
                    alert('net work err');
                }
            )
        }
    }


</script>
</html>
package com.example.demo.application;

import com.example.demo.domain.ListItemDTO;
import com.example.demo.domain.ListitemEntity;
import com.example.demo.repository.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ListItemService {
    @Autowired
    private ListItemRepository listItemRepository;

    public List<? extends ListItemDTO> getAllItems(){
        return listItemRepository.findAll();
    }

    public List<? extends ListItemDTO> getListItemDTOByListid(int listid){

        return listItemRepository.getByListid(listid);
    }

    public ListItemDTO getListItemDTOByContent(String content){
        return listItemRepository.getByContent(content);
    }

    public ListitemEntity createListitem(String content, int listid, String locationid){
        System.out.println("content" + content);
        return listItemRepository.save(new ListitemEntity(content, listid, locationid));
    }

    public ListItemDTO findListitemByItemid(int itemid) {
        return listItemRepository.findByItemid(itemid);
    }

    public ListitemEntity editListitem(ListitemEntity listItem) {
        return listItemRepository.save(listItem);
    }

    public int deleteListitem(int itemid) {
        return  listItemRepository.deleteByItemid(itemid);
    }
}
package com.example.demo.application;

import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListEntity;
import com.example.demo.domain.ListitemEntity;
import com.example.demo.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ListService {
    @Autowired
    private ListRepository listRepository;

    public List<ListDTO> getAllLists(String owner){
//        return listRepository.findAll();
        return listRepository.findAllByOwner(owner);
    }

    public ListDTO getByName(String listname){

        return listRepository.getByListname(listname);
    }

    public ListDTO getByNameAndOwner(String listname, String ownerid){

        return listRepository.getByListnameAndOwner(listname,ownerid);
    }

    public ListEntity createList(String listname, String owner){
        return listRepository.save(new ListEntity(listname, owner));
    }

    public ListDTO getListByListid(int listid) {
        return listRepository.getByListid(listid);
    }

    public ListDTO findListById(int listid) {
        return listRepository.findByListid(listid);
    }

    public ListEntity editList(ListEntity list) {
        return listRepository.save(list);
    }

    public int deleteList(int listid) { return listRepository.deleteByListid(listid);}

}
package com.example.demo.application;

import com.example.demo.domain.ListEntity;
import com.example.demo.domain.LocationDTO;
import com.example.demo.domain.LocationEntity;
import com.example.demo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public LocationDTO getLocationbyId(String locationid){

        return locationRepository.getLocationEntityByLocationid(locationid);
    }
    public List<? extends LocationDTO> getAllLocations(){
        return locationRepository.findAll();
    }

    public LocationEntity newLocation(String locationid, String name, String coord){
        return locationRepository.save(new LocationEntity(locationid, name, coord));
    }

}
package com.example.demo.application;

import com.example.demo.domain.UserEntity;
import com.example.demo.presentation.UserModel;
import com.example.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity getUserById(String userId){
        return userRepository.findUserEntityByUserId(userId);
    }

    public UserEntity getUserByName(String name){
        return userRepository.findByName(name);
    }

    public UserEntity login(String username, String password) throws Exception{
       UserEntity foundUser = getUserByName(username);

        if (foundUser == null) {
            return null;
        }
        else {
            String getPass = foundUser.getPassword();
            if(getPass.equals(password)) {
                return foundUser;
            }
            else {
                return null;
            }
        }
    }

    public UserEntity registerUser(String username, String password) throws Exception{
        UserEntity usernameExists = getUserByName(username);
        if (usernameExists != null) {
            throw new Exception();
        }
        else {
            return userRepository.save(new UserEntity(username, password));
        }
    }

    public UserEntity getUserByEmail(String email) { return userRepository.getUserEntityByEmail(email);}
}package com.example.demo.domain;

 import java.util.List;

 public interface ListDTO{
     String getListname();
     String getOwner();
     String getCollaborators();
     int getListid();
     void setListname(String listname);
     void setCollaborators(String collaborators);

 }
package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "list", schema = "public", catalog = "postgres")
public class ListEntity implements ListDTO{
    private int listid;
    private String listname;
    private String owner;
    private String collaborators;

    public ListEntity(String listname, String owner) {
        this.listname = listname;
        this.owner = owner;
    }

    public ListEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listid", nullable = false)
    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listEntity")
    private Set<ListitemEntity> listitemEntities;

    @Basic
    @Column(name = "listname", nullable = false, length = -1)
    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    @Basic
    @Column(name = "owner", nullable = true, length = -1)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "collaborators", nullable = true, length = -1)
    public String getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(String collaborators) {
        this.collaborators = collaborators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListEntity that = (ListEntity) o;
        return listid == that.listid &&
                Objects.equals(listname, that.listname) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(collaborators, that.collaborators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listid, listname, owner, collaborators);
    }
}
package com.example.demo.domain;

public interface ListItemDTO {
    String getContent();
    int getStatus();
    String getAssignee();
    int getListid();
    void setContent(String content);
    void setStatus(int status);
    void setAssignee(String assignee);
    void setLocationid(String locationid);


}
package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "listitem", schema = "public", catalog = "postgres")
public class ListitemEntity implements ListItemDTO{
    private int itemid;
    private String content;
    private int status;
    private int listid;
    private String assignee;
    private String locationid;
    private String location;

    public ListitemEntity(String content, int listid, String locationid) {
        this.content = content;
        this.listid = listid;
        this.locationid = locationid;
    }

    public ListitemEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemid", nullable = false)
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listid")
    private ListEntity listEntity;

    @Basic
    @Column(name = "listid", nullable = true)
    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    @Basic
    @Column(name = "assignee", nullable = true, length = -1)
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Basic
    @Column(name = "locationid", nullable = true, length = -1)
    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    @Basic
    @Column(name = "location", nullable = true, length = -1)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListitemEntity that = (ListitemEntity) o;
        return itemid == that.itemid &&
                Objects.equals(content, that.content) &&
                Objects.equals(status, that.status) &&
                Objects.equals(listid, that.listid) &&
                Objects.equals(assignee, that.assignee) &&
                Objects.equals(locationid, that.locationid) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemid, content, status, listid, assignee, locationid, location);
    }
}
package com.example.demo.domain;

public interface LocationDTO {
    String getLocationid();
    String getName();
    String getCoord();
    void setLocation(String locationid);
    void setName(String name);
    void setCoord(String coord);
}
package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "location", schema = "public", catalog = "dflnn18ltm94g1")
public class LocationEntity implements LocationDTO{
    private String locationid;
    private String name;
    private String coord;

    public LocationEntity(String locationid, String name, String coord) {
        this.locationid = locationid;
        this.name = name;
        this.coord = coord;
    }

    public LocationEntity() {
    }

    @Id
    @Column(name = "locationid", nullable = false, length = -1)
    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "coord", nullable = false, length = -1)
    public String getCoord() {
        return coord;
    }

    @Override
    public void setLocation(String locationid) {

    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationEntity that = (LocationEntity) o;
        return Objects.equals(locationid, that.locationid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(coord, that.coord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationid, name, coord);
    }
}
package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public", catalog = "postgres")
public class UserEntity implements UserDTO{
    private String userId;
    private String name;
    private String password;
    private String email;

//    @ManyToMany(targetEntity = StudygroupEntity.class)
//    private Set studyGroupSet;

    public UserEntity(String name, String password){
        super();
//        this.userId = userId;
        this.name = name;
        this.password = password;
//        this.email = email;
//        this.studyGroupSet = studyGroupSet;
    }

    public UserEntity() {
        super();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, length = -1)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email);
    }

//    public Set getStudyGroupSet() {
//        return studyGroupSet;
//    }
//
//    public void setStudyGroupSet(Set studyGroupSet) {
//        this.studyGroupSet = studyGroupSet;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, password, email);
    }
}
package com.example.demo.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "index.html";
    }
}
package com.example.demo.presentation;

import com.alibaba.fastjson.JSON;
import com.example.demo.application.ListItemService;
import com.example.demo.application.ListService;
import com.example.demo.application.LocationService;
import com.example.demo.application.UserService;
import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListItemDTO;
import com.example.demo.domain.ListitemEntity;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@RestController
public class ListController {
    @Autowired
    private UserService userService;
    @Autowired
    private ListService listService;
    @Autowired
    private ListItemService listItemService;
    @Autowired
    private LocationService locationService;

    @RequestMapping("/lists")
    public String getLists(@RequestParam("owner") String ownerid) {
       List<? extends ListDTO> allLists = listService.getAllLists(ownerid);

       JSONArray lists_res = new JSONArray();

       for (int i = 0; i < allLists.size(); i++) {
           ListDTO item= allLists.get(i);
//           System.out.println(item.toString());
           JSONObject temp = new JSONObject(JSON.toJSONString(item) );
//           System.out.println(temp.toString());
           List<? extends ListItemDTO> res =listItemService.getListItemDTOByListid(item.getListid());
           temp.put("items",res);
           lists_res.put(temp);
       }
       JSONObject res = new JSONObject();
       res.put("data",lists_res);
       res.put("status",200);
       res.put("locations",locationService.getAllLocations());
       return  res.toString();

    }
    @GetMapping("/test")
    public String test() {

        return "hello";
    }


    @RequestMapping(value = "/addList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newList(@RequestBody ListsModel listsModel) throws URISyntaxException {
        String listname = listsModel.getListname();
        String owner = listsModel.getOwner();

        ListDTO alist = listService.getByNameAndOwner(listname,owner);
        if (alist ==null||(alist!=null&&(!alist.getOwner().equals(owner)))){
            listService.createList(listname, owner);
            alist = listService.getByNameAndOwner(listname,owner);
            JSONObject temp = new JSONObject();
            temp.put("listname", listname);
            temp.put("listid", alist.getListid());
            temp.put("status", 200);
            return temp.toString();
        }else{
            JSONObject temp = new JSONObject();
            temp.put("status", 500);
            return temp.toString();
        }

    }

    @RequestMapping(value = "/deleteList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteList(@RequestBody ListsModel listsModel) throws URISyntaxException {
//        System.out.println(listitemModel.getItemid());
        int listid = listsModel.getListid();
        ListDTO listDTO = listService.findListById(listid);

        if (listDTO != null) {
            try {
                listService.deleteList(listid);
                JSONObject res = new JSONObject();
                res.put("status",200);
                res.put("msg","ok");
                return res.toString();
            }catch (Exception e){
                JSONObject res = new JSONObject();
                res.put("status",500);
                res.put("msg","cannot delete from DB");
                return res.toString();
            }

        }else{
            JSONObject res = new JSONObject();
            res.put("status",500);
            res.put("msg","No this list");
            return res.toString();
        }

    }

//    @RequestMapping(value = "/updateList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public List<ListDTO> editList(@RequestBody ListsModel addLists) throws URISyntaxException {
//        String listsName = addLists.getName();
//        int listid = addLists.getListid();
//        String collaborators = addLists.getCollaborators();
//        ListDTO listDTO = listService.findListById(listid);
//
//        if (listDTO != null) {
//            listDTO.setListname(listsName);
//            listDTO.setCollaborators(collaborators);
//            listService.editList((ListEntity) listDTO);
//        }
//
//        return (List<ListDTO>) listService.getAllLists();
//    }



    @RequestMapping("/listItems")
    public List<ListItemDTO> getListItems() {
        return (List<ListItemDTO>) listItemService.getAllItems();
    }

    @RequestMapping(value = "/addListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newListItem(@RequestBody ListitemModel listitemModel) throws URISyntaxException {
        String content = listitemModel.getContent();
        int listid = listitemModel.getListid();
        String locationid = listitemModel.getLocationid();
//        if(listItemService.getListItemDTOByContent(content) == null) {
            listItemService.createListitem(content, listid, locationid);
            List<? extends ListItemDTO> listitems = listItemService.getListItemDTOByListid(listid);
            JSONObject temp = new JSONObject();
            temp.put("data", listitems);
            temp.put("status", 200);
            System.out.println(locationid);
            if(locationid!=null&&locationService.getLocationbyId(locationid)==null){
                JSONObject details = getLocationDetail(locationid);
                if(details!=null && !details.has("error_message")){
                    JSONObject result = (JSONObject) details.get("result");
                    JSONObject geometry = (JSONObject) result.get("geometry");
                    String formatted_address =  result.getString("formatted_address");
                    String coord =  geometry.get("location").toString();
                    locationService.newLocation(locationid,formatted_address,coord);
                }else{
                    temp.put("status", 201);
                    temp.put("msg","location search exceeded google limits");
                }
            }
            temp.put("locations",locationService.getAllLocations());
            return temp.toString();
//        }else{
//            JSONObject temp = new JSONObject();
//            temp.put("status", 500);
//            temp.put("data", "this content already exists");
//            return temp.toString();
//        }

    }

    public JSONObject getLocationDetail(String place_id){
        try {
            String msg ="";
            String str = "https://maps.googleapis.com/maps/api/place/details/json?place_id="+place_id+"&fields=name,formatted_address,place_id,geometry&key=AIzaSyCP9q-M75_Wf5mvA1n6ZSevt7qskz83_mo";
            URL url = new URL(str);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode =  connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream inStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    msg+=line;
                }
                System.out.println(msg);
                bufferedReader.close();
                connection.disconnect();
            }
            return new JSONObject(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @RequestMapping(value = "/updateListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateListItem(@RequestBody ListitemModel listitemModel) throws URISyntaxException {
        String content = listitemModel.getContent();
        int itemid = listitemModel.getItemid();
        int status = listitemModel.getStatus();
//        String assignee = listitemModel.getAssignee();
        String locationid = listitemModel.getLocationid();
        ListItemDTO listItemDTO = listItemService.findListitemByItemid(itemid);

        if (listItemDTO != null) {
            listItemDTO.setContent(content);
            listItemDTO.setStatus(status);
            listItemDTO.setLocationid(locationid);
            listItemService.editListitem((ListitemEntity) listItemDTO);

            int listid = listItemDTO.getListid();
            List<? extends ListItemDTO> listitems = listItemService.getListItemDTOByListid(listid);
            JSONObject res = new JSONObject();
            res.put("data",listitems);
            res.put("listid",listid);
            res.put("status",200);
            if(locationid!=null&&locationService.getLocationbyId(locationid)==null){
                JSONObject details = getLocationDetail(locationid);
                if(details!=null && !details.has("error_message")){
                    JSONObject result = (JSONObject) details.get("result");
                    JSONObject geometry = (JSONObject) result.get("geometry");
                    String formatted_address =  result.getString("formatted_address");
                    String coord =  geometry.get("location").toString();
                    locationService.newLocation(locationid,formatted_address,coord);
                }else{
                    res.put("status", 201);
                    res.put("msg","location search exceeded google limits");
                }
            }
            res.put("locations",locationService.getAllLocations());
            return res.toString();
        }else{
            JSONObject res = new JSONObject();
            res.put("status",500);
            res.put("msg","No this item");
            return res.toString();
        }

    }

    @RequestMapping(value = "/deleteListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteListItem(@RequestBody ListitemModel listitemModel) throws URISyntaxException {
//        System.out.println(listitemModel.getItemid());
        int itemid = listitemModel.getItemid();
        ListItemDTO listItemDTO = listItemService.findListitemByItemid(itemid);

        if (listItemDTO != null) {
            listItemService.deleteListitem(itemid);
            JSONObject res = new JSONObject();
            res.put("status",200);
            res.put("msg","ok");
            return res.toString();
        }else{
            JSONObject res = new JSONObject();
            res.put("status",500);
            res.put("msg","No this item");
            return res.toString();
        }

    }

//    public boolean validateToken(String token) {
//        //System.out.println(token);
//        if (token == null) {
//            return false;
//        }
//
//        try {
//            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
//            if (Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject().equals("john")) {
//                String str = body.toLowerCase();
//                Message res = game.guess(str);
//                Message.sendMsg(output, res);
//                if (res.getType().equals("finish")) {
//                    this.score = Integer.valueOf(res.getBody());
//                    Message start_msg = new Message("update", game.getUnderline() + "," + Integer.toString(game.getCounter()) + "," + Integer.toString(game.getScore()));
//                    Message.sendMsg(output, start_msg);
//                }
//            } else {
//                Message start_msg = new Message("login", "user is not authenticated");
//                Message.sendMsg(output, start_msg);
//            }
//        } catch (JwtException e) {
//            Message start_msg = new Message("login", "user is not authenticated");
//            Message.sendMsg(output, start_msg);
//        }
//    }
}
package com.example.demo.presentation;

import com.example.demo.application.LocationService;
import com.example.demo.domain.ListItemDTO;
import com.example.demo.domain.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/addLocation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LocationDTO newLocation(@RequestBody LocationModel locationModel) throws URISyntaxException {
        String locationid = locationModel.getLocationid();
        String name = locationModel.getName();
        String coord = locationModel.getCoord();

        return locationService.newLocation(locationid, name, coord);
    }

    @GetMapping ("/location")
    public LocationDTO getLocation(String locationid)
    {
        return locationService.getLocationbyId(locationid);
    }

}
package com.example.demo.presentation;

public class LocationModel {
    private String locationid;
    private String name;
    private String coord;

    public String getLocationid() { return locationid; }

    public void setLocationid(String locationid) { this.locationid = locationid; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCoord() { return coord; }

    public void setCoord(String coord) { this.coord = coord; }

}
package com.example.demo.presentation;

import com.example.demo.application.UserService;
import com.example.demo.domain.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Key;
import java.util.Date;

//@SessionAttributes("user")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
//    Key key;

//    @ModelAttribute("user")
//    public UserService create() {
//        return new UserService();
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody UserModel user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        try{
            userService.registerUser(username, password);
            JSONObject res =  new JSONObject();
            res.put("status", 200);
            return res.toString();
        } catch (Exception ex) {
            System.out.println("Registration failed");
            JSONObject res =  new JSONObject();
            res.put("status",500);
            return res.toString();
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UserModel user) throws Exception {
        UserEntity loggedInUser = null;
        String username = user.getUsername();
        String password = user.getPassword();

        try {
//            key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//            Date date = new Date();
//            long d = date.getTime();
//            date = new Date(d + 30 * 60 * 1000);
//            /**
//             * Here we are constructing the JWT token for authentication
//             */
//            String jws = Jwts.builder().setSubject("john").setExpiration(date).signWith(key).compact();
            loggedInUser = userService.login(username, password);
            JSONObject res =  new JSONObject();
            String userid = loggedInUser.getUserId();
            res.put("status", 200);
            res.put("userid", userid);
            res.put("username",username);
//            res.put("token", jws);
            return res.toString();
        } catch (Exception ex) {
           System.out.println("Login failed");
            JSONObject res =  new JSONObject();
            res.put("status",500);
           return res.toString();
        }
    }


}
