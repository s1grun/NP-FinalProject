package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "listitem", schema = "public", catalog = "postgres")
public class ListitemEntity implements ListItemDTO{
    private int itemid;
    private String content;
    private int status;
    private int listid;
    private String assignee;
    private String locationid;
    private String location;

    public ListitemEntity(String content) {
        this.content = content;
    }

    public ListitemEntity() {
    }

    @Id
    @Column(name = "itemid", nullable = false)
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listid")
    private ListEntity listEntity;

    @Basic
    @Column(name = "listid", nullable = true)
    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    @Basic
    @Column(name = "assignee", nullable = true, length = -1)
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Basic
    @Column(name = "locationid", nullable = true, length = -1)
    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    @Basic
    @Column(name = "location", nullable = true, length = -1)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListitemEntity that = (ListitemEntity) o;
        return itemid == that.itemid &&
                Objects.equals(content, that.content) &&
                Objects.equals(status, that.status) &&
                Objects.equals(listid, that.listid) &&
                Objects.equals(assignee, that.assignee) &&
                Objects.equals(locationid, that.locationid) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemid, content, status, listid, assignee, locationid, location);
    }
}
