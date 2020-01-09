

function AjaxRequests() {

}

AjaxRequests.prototype.getAlLists= function(req,successCallback,failCallback){
    successCallback = typeof successCallback === 'function'?successCallback:new Function();
    failCallback = typeof failCallback === 'function'?failCallback:new Function();

    $.ajax({
        url:'http://localhost:8080/lists',
        type:'GET',
        contentType:'application/json',
        // dataType:"JSON",
        success:function(data,state){
            successCallback(JSON.parse(data) ,state)},
        error:function(data,state){
            failCallback(data,state)}
    })
};


AjaxRequests.prototype.getAlLists= function(req,successCallback,failCallback){
    successCallback = typeof successCallback === 'function'?successCallback:new Function();
    failCallback = typeof failCallback === 'function'?failCallback:new Function();

    $.ajax({
        url:'http://localhost:8080/login',
        type:'POST',
        contentType:'application/json',
        // dataType:"JSON",
        success:function(data,state){
            successCallback(JSON.parse(data) ,state)},
        error:function(data,state){
            failCallback(data,state)}
    })
};