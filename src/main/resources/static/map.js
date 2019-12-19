/**
 * Created by weng on 2019/12/18.
 */


// window.onload = function () {
//     getCurrentLocation();
// }

var autocomplete;
var input_option={
    input:"",
};

function getCurrentLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(onSuccess, onError);
    } else {
        alert("your browser doesn't support location");
    }
    function onSuccess(position) {
        var geolocation = {
            lat: position.coords.latitude,
            lng: position.coords.longitude
        };
        var circle = new google.maps.Circle(
            {center: geolocation, radius: position.coords.accuracy});
        input_option.bounds =  circle.getBounds();
        console.log(geolocation);

    }
    function onError() {
        console.log('get location error');
    }

}


var next_search=true;
function init_autocomplete(){
    var input = document.getElementById('location');
    var input2 = document.getElementById('location2');

    autocomplete = new google.maps.places.AutocompleteService();

    input.oninput = function(){bindInput('location','location_form')};
    input2.oninput = function(){bindInput('location2','location_form2')};
    getCurrentLocation();
}

function bindInput(inputid,formid) {
    var input = document.getElementById(inputid);
    if(next_search){
        next_search = false;
        var timer = setTimeout(function () {

            input_option.input = input.value;
            autocomplete.getPlacePredictions(input_option, function(res){
                if(res != null){
                    AddingLocation = null;
                    var location_list = document.getElementById(formid);
                    location_list.innerHTML ='';
                    res.map(function(item,index){
                        location_list.innerHTML+=`<p>
                    <label>
                        <input  value="${item.place_id}" class="with-gap" name="location_value" type="radio" onclick="clickRadio('${item.place_id}','${item.description}')"/>
                        <span>${item.description}</span>
                    </label>
                </p>`;
                    })
                }
            });
            next_search=true;
        },3000);

    }
};



function init_smallmap() {

}

function clickRadio(placeid,desc) {
    AddingLocation = {location:desc,locationid : placeid};
    console.log(placeid,desc);
}


