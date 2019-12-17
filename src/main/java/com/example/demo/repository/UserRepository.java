package com.example.demo.repository;

import com.example.demo.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String name);
    UserEntity findUserEntityByUserId(String userid);
    UserEntity getUserEntityByNameAndPassword(String name, String password);
    boolean existsByName(String name);
}
