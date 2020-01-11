package com.example.demo.domain;

public interface LocationDTO {
    String getLocationid();
    String getName();
    String getCoord();
    void setLocation(String locationid);
    void setName(String name);
    void setCoord(String coord);
}
