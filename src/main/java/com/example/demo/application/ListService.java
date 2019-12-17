package com.example.demo.application;

import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListEntity;
import com.example.demo.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ListService {
    @Autowired
    private ListRepository listRepository;

    public List<? extends ListDTO> getAllLists(){
        return listRepository.findAll();
    }

    public ListDTO getByName(String listname){

        return listRepository.getListEntityByListname(listname);
    }

    public ListEntity createList(String listname, String owner){

        return listRepository.save(new ListEntity(listname,owner));
    }

}
