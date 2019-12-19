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
//        return listRepository.findAll();
        return listRepository.findAll();
    }

    public ListDTO getByName(String listname){

        return listRepository.getByListname(listname);
    }

    public ListEntity createList(String listname){
        System.out.println("Listname" + listname);
        return listRepository.save(new ListEntity(listname));
    }

    public ListDTO getListByListid(int listid) {
        return listRepository.getByListid(listid);
    }

}
