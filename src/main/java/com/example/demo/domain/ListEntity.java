package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "list", schema = "public", catalog = "postgres")
public class ListEntity {
    private int listId;
    private String listname;
    private String owner;
    private String collaborators;
    private String listitem;
    private String content;
    private String assignee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listID", nullable = false)
    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    @Basic
    @Column(name = "listname", nullable = false, length = -1)
    public String getUsername() {
        return listname;
    }

    public void setUsername(String username) {
        this.listname = username;
    }

    @Basic
    @Column(name = "owner", nullable = false, length = -1)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "collaborators", nullable = false, length = -1)
    public String getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(String collaborators) {
        this.collaborators = collaborators;
    }

    @Basic
    @Column(name = "listitem", nullable = false, length = -1)
    public String getListitem() {
        return listitem;
    }

    public void setListitem(String listitem) {
        this.listitem = listitem;
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
    @Column(name = "assignee", nullable = true, length = -1)
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListEntity that = (ListEntity) o;
        return listId == that.listId &&
                Objects.equals(listname, that.listname) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(collaborators, that.collaborators) &&
                Objects.equals(listitem, that.listitem) &&
                Objects.equals(content, that.content) &&
                Objects.equals(assignee, that.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId, listname, owner, collaborators, listitem, content, assignee);
    }
}
