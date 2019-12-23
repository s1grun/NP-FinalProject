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

var global_map = null;

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
        global_map = init_smallmap(geolocation);

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



function clickRadio(placeid,desc) {
    AddingLocation = {location:desc,locationid : placeid};
    console.log(placeid,desc);
}






function init_smallmap(center_location) {
    var map = new google.maps.Map(document.getElementById('map'), {
        center: center_location,
        zoom: 10
      });
    return map;
}

function mark_map_location(map,request,content){
    var infowindow = new google.maps.InfoWindow();
    var service = new google.maps.places.PlacesService(map);
    service.getDetails(request, function(place, status) {
        if (status === google.maps.places.PlacesServiceStatus.OK) {
          var marker = new google.maps.Marker({
            map: map,
            position: place.geometry.location
          });
          google.maps.event.addListener(marker, 'click', function() {
            infowindow.setContent('<div><strong>' + place.name + '</strong><br>' +
              'Place ID: ' + place.place_id + '<br>' + 'content:'+content+'<br>'+
              place.formatted_address + '</div>');
            infowindow.open(map, this);
          });
        }
    });
}

function refresh_map(){
    if(global_map!=null){
        var index =0;
        for (var id in global_Items){
            var item = global_Items[id];
            var req={
                placeId :item.locationid,
                fields: ['name', 'formatted_address', 'place_id', 'geometry']
            };
            (function(req,ind, content){
                setTimeout(function(){
                    mark_map_location(global_map,req,content)
                },2000*ind)
            })(req,index,item.content)
            index+=1;
        }
        
    }else{
        setTimeout(function(){
            refresh_map();
        },1000)
    }
    
}

