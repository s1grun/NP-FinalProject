package com.example.demo.application;

import com.example.demo.domain.ListItemDTO;
import com.example.demo.domain.ListitemEntity;
import com.example.demo.repository.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ListItemService {
    @Autowired
    private ListItemRepository listItemRepository;

    public List<? extends ListItemDTO> getAllItems(){
        return listItemRepository.findAll();
    }

    public List<? extends ListItemDTO> getListItemDTOByListid(int listid){

        return listItemRepository.getByListid(listid);
    }

    public ListItemDTO getListItemDTOByContent(String content){
        return listItemRepository.getByContent(content);
    }

    public ListitemEntity createListitem(String content, int listid, String locationid){
        System.out.println("content" + content);
        return listItemRepository.save(new ListitemEntity(content, listid, locationid));
    }

    public ListItemDTO findListitemByItemid(int itemid) {
        return listItemRepository.findByItemid(itemid);
    }

    public ListitemEntity editListitem(ListitemEntity listItem) {
        return listItemRepository.save(listItem);
    }

    public int deleteListitem(int itemid) {
        return  listItemRepository.deleteByItemid(itemid);
    }
}
