package com.example.demo.repository;

import com.example.demo.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
