package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public", catalog = "postgres")
public class UserEntity {
    private String userId;
    private String name;
    private String password;
    private String email;

    @ManyToMany(targetEntity = StudygroupEntity.class)
    private Set studyGroupSet;

    public UserEntity(String userId, String name, String password, String email, Set studyGroupSet){
        super();
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.studyGroupSet = studyGroupSet;
    }

    public UserEntity() {
        super();
    }


    @Id
    @Column(name = "user_id", nullable = false, length = -1)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email);
    }

    public Set getStudyGroupSet() {
        return studyGroupSet;
    }

    public void setStudyGroupSet(Set studyGroupSet) {
        this.studyGroupSet = studyGroupSet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, password, email);
    }
}
