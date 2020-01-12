package com.example.demo.presentation;

import com.example.demo.domain.ListDTO;

public class ListsModel implements ListDTO {
    private String listname;
    private int listid;
    private String owner;
    private String collaborators;

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public String getOwner() {return owner; }

    public void setOwner(String owner) { this.owner = owner; }

    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    public String getCollaborators() { return collaborators; }

    public void setCollaborators(String collaborators) { this.collaborators = collaborators; }
}
