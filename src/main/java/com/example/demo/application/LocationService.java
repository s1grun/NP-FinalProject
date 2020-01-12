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
