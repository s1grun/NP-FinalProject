package com.example.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
}
