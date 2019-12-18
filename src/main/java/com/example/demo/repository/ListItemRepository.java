package com.example.demo.repository;

import com.example.demo.domain.ListItemDTO;
import com.example.demo.domain.ListitemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface ListItemRepository extends JpaRepository<ListitemEntity, List> {
    ListItemDTO getByListid(int listid);
    //ListItemDTO getListItemDTOByListid(int listid);
    ListItemDTO getByContent(String content);
}
