package com.example.demo.presentation;

public class AddListItem {

    private String content;
    private int itemid;
    private int status;
    private String assignee;
    private int listid;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content.toUpperCase();
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public int getListid() {return listid; }

    public void setListid(int listid) { this.listid = listid; }
}
