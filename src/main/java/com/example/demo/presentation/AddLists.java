package com.example.demo.presentation;

public class AddLists {
    private String name;
    private int listid;
    private String owner;
    private String collaborators;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
