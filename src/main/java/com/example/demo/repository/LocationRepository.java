package com.example.demo.repository;

import com.example.demo.domain.LocationDTO;
import com.example.demo.domain.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface LocationRepository extends JpaRepository<LocationEntity, List> {
    LocationDTO getLocationEntityByLocationid(String locationid);
}
