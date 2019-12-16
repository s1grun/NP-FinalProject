package com.example.demo.repository;

import com.example.demo.entity.UsersingroupEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;

@Repository
@Transactional
public interface UsersingroupRepository extends JpaRepository<UsersingroupEntity, List> {
}
