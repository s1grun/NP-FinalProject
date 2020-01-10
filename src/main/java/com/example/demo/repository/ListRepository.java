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
public interface ListRepository extends JpaRepository<ListEntity, List> {
//    ListDTO getListEntityByListname(String listname);
    ListDTO getByListname(String listname);
//    ListDTO getAllByListname();
    ListDTO getByListid(int listid);
    List<ListEntity> findAll();
    ListDTO findByListid(int listid);
}
