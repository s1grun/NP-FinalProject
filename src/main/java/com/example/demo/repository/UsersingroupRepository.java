package com.example.demo.repository;

import com.example.demo.domain.UsersingroupEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UsersingroupRepository extends JpaRepository<UsersingroupEntity, Long> {
}
