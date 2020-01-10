package com.example.demo.application;

import com.example.demo.domain.UserEntity;
import com.example.demo.presentation.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity getUserById(String userId){
        return userRepository.findUserEntityByUserId(userId);
    }

    public UserEntity getUserByName(String name){
        return userRepository.findByName(name);
    }

    public UserEntity login(String username, String password) throws Exception{
       UserEntity foundUser = getUserByName(username);

        if (foundUser == null) {
            return null;
        }
        else {
            String getPass = foundUser.getPassword();
            if(getPass.equals(password)) {
                return foundUser;
            }
            else {
                return null;
            }
        }
    }

    public void saveUser(UserEntity userEntity) throws Exception{
        boolean usernameExists = userRepository.existsByName(userEntity.getName());
        if (usernameExists)
            throw new Exception();
        userRepository.save(userEntity);
    }

    public UserEntity getUserByEmail(String email) { return userRepository.getUserEntityByEmail(email);}
}