package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "studygroup", schema = "public", catalog = "postgres")
public class StudygroupEntity {
    private int groupid;
    private String groupname;

    @ManyToMany(targetEntity = UserEntity.class)
    private Set userSet;

    public StudygroupEntity() {
        super();
    }


    public StudygroupEntity(int groupid, String groupname, Set userSet){
        super();
        this.groupid = groupid;
        this.groupname = groupname;
        this.userSet = userSet;
    }

    @Id
    @Column(name = "groupid", nullable = false)
    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @Basic
    @Column(name = "groupname", nullable = false, length = -1)
    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudygroupEntity that = (StudygroupEntity) o;
        return groupid == that.groupid &&
                Objects.equals(groupname, that.groupname);
    }

    public Set getUserSet() {
        return userSet;
    }

    public void setUserSet(Set userSet) {
        this.userSet = userSet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupid, groupname);
    }
}
