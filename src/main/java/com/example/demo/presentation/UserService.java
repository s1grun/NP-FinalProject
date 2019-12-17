package com.example.demo.presentation;

import com.example.demo.domain.UserEntity;

public interface UserService {
    void registerUser(UserEntity userEntity);
    UserEntity findByName(String name);
}
