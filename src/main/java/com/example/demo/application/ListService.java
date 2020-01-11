package com.example.demo.application;

import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListEntity;
import com.example.demo.domain.ListitemEntity;
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

    public List<? extends ListDTO> getAllLists(String owner){
//        return listRepository.findAll();
        return listRepository.findAllByOwner(owner);
    }

    public ListDTO getByName(String listname){

        return listRepository.getByListname(listname);
    }

    public ListEntity createList(String listname, String owner){
        return listRepository.save(new ListEntity(listname, owner));
    }

    public ListDTO getListByListid(int listid) {
        return listRepository.getByListid(listid);
    }

    public ListDTO findListById(int listid) {
        return listRepository.findByListid(listid);
    }

    public ListEntity editList(ListEntity list) {
        return listRepository.save(list);
    }

}
