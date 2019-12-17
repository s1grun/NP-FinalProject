package com.example.demo.repository;


import com.example.demo.domain.StudygroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudygroupRepository extends JpaRepository<StudygroupEntity, Long> {
}
