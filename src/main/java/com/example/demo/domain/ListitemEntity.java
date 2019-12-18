package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "listitem", schema = "public", catalog = "postgres")
public class ListitemEntity implements ListItemDTO{
    private int itemid;
    private String content;
    private String status;
    private int listid;

    public ListitemEntity(String content) {
        this.content = content;
    }

    public ListitemEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "status", nullable = true, length = -1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "listid", nullable = true)
    public int getListid() {
        return listid;
    }

    public void setListid(int listid) {
        this.listid = listid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListitemEntity that = (ListitemEntity) o;
        return itemid == that.itemid &&
                listid == that.listid &&
                Objects.equals(content, that.content) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemid, content, status, listid);
    }
}
