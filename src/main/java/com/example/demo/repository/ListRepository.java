package com.example.demo.repository;

import com.example.demo.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ListRepository extends JpaRepository<ListEntity, List> {
}
