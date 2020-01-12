

function AjaxRequests() {

}

AjaxRequests.prototype.getAlLists= function(req,successCallback,failCallback){
    successCallback = typeof successCallback === 'function'?successCallback:new Function();
    failCallback = typeof failCallback === 'function'?failCallback:new Function();

    $.ajax({
        url:'http://localhost:8080/lists?owner='+req,
        type:'GET',
        contentType:'application/json',
        // dataType:"JSON",
        success:function(data,state){
            successCallback(JSON.parse(data) ,state)},
        error:function(data,state){
            failCallback(data,state)}
    })
};


AjaxRequests.prototype.login= function(req,successCallback,failCallback){
    successCallback = typeof successCallback === 'function'?successCallback:new Function();
    failCallback = typeof failCallback === 'function'?failCallback:new Function();

    $.ajax({
        url:'http://localhost:8080/login',
        type:'POST',
        contentType:'application/json',
        dataType:"JSON",
        data:JSON.stringify(req),
        success:function(data,state){
            successCallback(JSON.parse(JSON.stringify(data) ) ,state)},
        error:function(data,state){
            failCallback(data,state)}
    })
};


AjaxRequests.prototype.updateItem= function(req,successCallback,failCallback){
    successCallback = typeof successCallback === 'function'?successCallback:new Function();
    failCallback = typeof failCallback === 'function'?failCallback:new Function();

    $.ajax({
        url:'http://localhost:8080/updateListItem',
        type:'POST',
        data:JSON.stringify(req),
        contentType:'application/json',
        dataType:"JSON",
        success:function(data,state){
            successCallback(JSON.parse(JSON.stringify(data) ),state)},
        error:function(data,state){
            failCallback(data,state)}
    })
};

AjaxRequests.prototype.addItem= function(req,successCallback,failCallback){
    successCallback = typeof successCallback === 'function'?successCallback:new Function();
    failCallback = typeof failCallback === 'function'?failCallback:new Function();
    console.log(req);
    $.ajax({
        url:'http://localhost:8080/addListItem',
        type:'post',
        data:JSON.stringify(req),
        contentType: "application/json; charset=utf-8",
        // dataType:"JSON",
        success:function(data,state){
            successCallback(JSON.parse(data ) ,state)},
        error:function(data,state){
            failCallback(data,state)}
    })
};


AjaxRequests.prototype.addList= function(req,successCallback,failCallback){
    successCallback = typeof successCallback === 'function'?successCallback:new Function();
    failCallback = typeof failCallback === 'function'?failCallback:new Function();
    
    $.ajax({
        url:'http://localhost:8080/addList',
        type:'post',
        data:JSON.stringify(req),
        contentType: "application/json;charset=utf-8",
        // dataType:"JSON",
        success:function(data,state){
            successCallback(JSON.parse(data) ,state)},
        error:function(data,state){
            failCallback(data,state)}
    })
};


AjaxRequests.prototype.deleteItem= function(req,successCallback,failCallback){
    successCallback = typeof successCallback === 'function'?successCallback:new Function();
    failCallback = typeof failCallback === 'function'?failCallback:new Function();

    $.ajax({
        url:'http://localhost:8080/deleteListItem',
        type:'post',
        data:JSON.stringify(req),
        contentType: "application/json;charset=utf-8",
        // dataType:"JSON",
        success:function(data,state){
            successCallback(JSON.parse(data) ,state)},
        error:function(data,state){
            failCallback(data,state)}
    })
};