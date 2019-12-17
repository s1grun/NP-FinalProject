package com.example.demo.repository;

import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface ListRepository extends JpaRepository<ListEntity, Long> {
    ListDTO getListEntityByListname(String listname);
//    ListDTO getAllByListname();
}
