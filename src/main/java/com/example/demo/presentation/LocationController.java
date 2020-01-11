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
