package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "list", schema = "public", catalog = "postgres")
public class ListEntity implements ListDTO{
    private int listid;
    private String listname;
    private String owner;
    private String collaborators;

    public ListEntity(String listname) {
        this.listname = listname;
    }

    public ListEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listid", nullable = false)
    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    @Basic
    @Column(name = "listname", nullable = false, length = -1)
    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    @Basic
    @Column(name = "owner", nullable = true, length = -1)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "collaborators", nullable = true, length = -1)
    public String getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(String collaborators) {
        this.collaborators = collaborators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListEntity that = (ListEntity) o;
        return listid == that.listid &&
                Objects.equals(listname, that.listname) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(collaborators, that.collaborators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listid, listname, owner, collaborators);
    }
}
