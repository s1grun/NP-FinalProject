package com.example.demo.domain;

import java.util.List;

public interface ListDTO{
    String getListname();
    String getOwner();
    String getCollaborators();
    int getListid();
    void setListname(String listname);
    void setCollaborators(String collaborators);

}
