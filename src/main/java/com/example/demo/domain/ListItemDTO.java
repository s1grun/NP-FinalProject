package com.example.demo.domain;

public interface ListItemDTO {
    String getContent();
    int getStatus();
    String getAssignee();
    int getListid();
    void setContent(String content);
    void setStatus(int status);
    void setAssignee(String assignee);
    void setLocationid(String locationid);


}
