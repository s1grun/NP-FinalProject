package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usersingroup", schema = "public", catalog = "postgres")
public class UsersingroupEntity {
    private int userid;
    private int groupid;

    @Basic
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "groupid", nullable = false)
    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersingroupEntity that = (UsersingroupEntity) o;
        return userid == that.userid &&
                groupid == that.groupid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, groupid);
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
