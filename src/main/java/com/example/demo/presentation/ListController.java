package com.example.demo.presentation;

import com.example.demo.application.ListItemService;
import com.example.demo.application.ListService;
import com.example.demo.application.UserService;
import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListEntity;
import com.example.demo.domain.ListItemDTO;
import com.example.demo.domain.ListitemEntity;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ListController {
    @Autowired
    private UserService userService;
    @Autowired
    private ListService listService;
    @Autowired
    private ListItemService listItemService;

    @RequestMapping("/lists")
    public String getLists() {
       List<? extends ListDTO> allLists = listService.getAllLists();


       JSONArray lists_res = new JSONArray();

       for (int i = 0; i < allLists.size(); i++) {

           ListDTO item= allLists.get(i);
           System.out.println(item.toString());
           JSONObject temp = new JSONObject(item);
           System.out.println(temp.toString());
           List<? extends ListItemDTO> res =listItemService.getListItemDTOByListid(item.getListid());
           temp.put("items",res);
           lists_res.put(temp);
       }
        return  lists_res.toString();

    }

    @RequestMapping(value = "/addList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ListDTO> newList(@RequestBody AddLists addLists) throws URISyntaxException {
        String listname = addLists.getName();
        if (listService.getByName(listname) == null) {
            listService.createList(listname);
        }
        return (List<ListDTO>) listService.getAllLists();
    }

//    @RequestMapping(value = "/updateList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public List<ListDTO> editList(@RequestBody AddLists addLists) throws URISyntaxException {
//        String listsName = addLists.getName();
//        int listid = addLists.getListid();
//        String collaborators = addLists.getCollaborators();
//        ListDTO listDTO = listService.findListById(listid);
//
//        if (listDTO != null) {
//            listDTO.setListname(listsName);
//            listDTO.setCollaborators(collaborators);
//            listService.editList((ListEntity) listDTO);
//        }
//
//        return (List<ListDTO>) listService.getAllLists();
//    }



    @RequestMapping("/listItems")
    public List<ListItemDTO> getListItems() {
        return (List<ListItemDTO>) listItemService.getAllItems();
    }

    @RequestMapping(value = "/addListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ListItemDTO> newListItem(@RequestBody AddListItem addListItem) throws URISyntaxException {
        String content = addListItem.getContent();
        int listid = addListItem.getListid();
        if(listItemService.getListItemDTOByContent(content) == null) {
            listItemService.createListitem(content, listid);
        }
        return (List<ListItemDTO>) listItemService.getAllItems();
    }

    @RequestMapping(value = "/updateListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ListItemDTO> updateListItem(@RequestBody AddListItem addListItem) throws URISyntaxException {
        String content = addListItem.getContent();
        int itemid = addListItem.getItemid();
        int status = addListItem.getStatus();
        String assignee = addListItem.getAssignee();
        ListItemDTO listItemDTO = listItemService.findListitemByItemid(itemid);

        if (listItemDTO != null) {
            listItemDTO.setContent(content);
            listItemDTO.setStatus(status);
            listItemDTO.setAssignee(assignee);
            listItemService.editListitem((ListitemEntity) listItemDTO);
        }
        return (List<ListItemDTO>) listItemService.getAllItems();
    }

    @RequestMapping(value = "/deleteListItem", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ListItemDTO> deleteListItem(@RequestBody AddListItem addListItem) throws URISyntaxException {
        int itemid = addListItem.getItemid();
        ListItemDTO listItemDTO = listItemService.findListitemByItemid(itemid);

        if (listItemDTO != null) {
            listItemService.deleteListitem((ListitemEntity) listItemDTO);
        }
        return (List<ListItemDTO>) listItemService.getAllItems();
    }

//    public boolean validateToken(String token) {
//        //System.out.println(token);
//        if (token == null) {
//            return false;
//        }
//
//        try {
//            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
//            if (Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject().equals("john")) {
//                String str = body.toLowerCase();
//                Message res = game.guess(str);
//                Message.sendMsg(output, res);
//                if (res.getType().equals("finish")) {
//                    this.score = Integer.valueOf(res.getBody());
//                    Message start_msg = new Message("update", game.getUnderline() + "," + Integer.toString(game.getCounter()) + "," + Integer.toString(game.getScore()));
//                    Message.sendMsg(output, start_msg);
//                }
//            } else {
//                Message start_msg = new Message("login", "user is not authenticated");
//                Message.sendMsg(output, start_msg);
//            }
//        } catch (JwtException e) {
//            Message start_msg = new Message("login", "user is not authenticated");
//            Message.sendMsg(output, start_msg);
//        }
//    }
}
