package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "location", schema = "public", catalog = "dflnn18ltm94g1")
public class LocationEntity {
    private String locationid;
    private String name;
    private String coord;

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
