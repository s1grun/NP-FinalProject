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
            if(input_option.input!=''){
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
            }else{
                var location_list = document.getElementById(formid);
                location_list.innerHTML ='';
                AddingLocation = null;
            }

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

var markers=[];
function mark_map_location(map,locationid,content){
    var infowindow = new google.maps.InfoWindow();
    var service = new google.maps.places.PlacesService(map);

    if(locationid!=""&&locationid!==undefined&&locations[locationid]!=undefined){
        var marker = new google.maps.Marker({
            map: map,
            position: JSON.parse(locations[locationid].coord)
        });
        markers.push(marker);
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.setContent('<div><strong>' + 'content: '+content + '</strong><br>' +

                locations[locationid].name + '</div>');
            infowindow.open(map, this);
        });
    }



}

function refresh_map(){
    markers.map((item,ind)=>{
        item.setMap(null);
    });
    markers =[];
    if(global_map!=null){
        var index =0;
        for (var id in global_Items){
            var item = global_Items[id];
            // var req={
            //     placeId :item.locationid,
            //     fields: ['name', 'formatted_address', 'place_id', 'geometry']
            // };
            (function(ind, it){
                setTimeout(function(){
                    mark_map_location(global_map,it.locationid,it.content)
                },100*ind)
            })(index,item)
            index+=1;
        }
        
    }else{
        setTimeout(function(){
            refresh_map();
        },1000)
    }
    
}

