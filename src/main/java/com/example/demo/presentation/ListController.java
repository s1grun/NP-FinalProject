package com.example.demo.presentation;

import com.example.demo.application.ListItemService;
import com.example.demo.application.ListService;
import com.example.demo.application.UserService;
import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListItemDTO;
import com.example.demo.domain.ListitemEntity;
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

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

//    @PostMapping("/login")
//    public String loginUser(@Valid UserEntity userEntity, BindingResult result, Model model) throws Exception{
//        UserEntity userloggedIn = null;
//        try {
//            userloggedIn = userService.login(userEntity);
//        } catch (Exception ex) {
//            throw new Exception();
//        }
//
//        model.addAttribute("username", userloggedIn.getName());
//        model.addAttribute("userId", userloggedIn.getUserId());
//
//        return returnTo("list-view", model);
//    }

//    @GetMapping ("/")
//    public String getLists(){
//        List<? extends ListDTO> allLists = listService.getAllLists();
////        model.addAttribute("allLists", allLists);
//
//        return "index";
//    }

    @RequestMapping("/lists")
    public List<ListDTO> getLists() {
       List<? extends ListDTO> allLists = listService.getAllLists();
//       int listid;
//
//       for (int i = 0; i < allLists.size(); i++) {
//           List<? extends ListItemDTO> res =listItemService.getListItemDTOByListid(allLists.get(i).getListid());
//           allLists.get(i).
//       }
        return (List<ListDTO>) allLists;

    }

    @RequestMapping(value = "/addList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ListDTO> newList(@RequestBody AddLists addLists) throws URISyntaxException {
        String listname = addLists.getName();
        if (listService.getByName(listname) == null) {
            listService.createList(listname);
        }
        return (List<ListDTO>) listService.getAllLists();
    }

    @RequestMapping("/listItems")
    public List<ListItemDTO> getListItems() {
        return (List<ListItemDTO>) listItemService.getAllItems();
    }

    @RequestMapping(value = "/addListItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ListItemDTO> newListItem(@RequestBody AddListItem addListItem) throws URISyntaxException {
        String content = addListItem.getContent();
        if(listItemService.getListItemDTOByContent(content) == null) {
            listItemService.createListitem(content);
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

//    @RequestMapping(value = "/deleteListItem", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public List<ListItemDTO> deleteListItem(@RequestBody AddListItem addListItem) throws URISyntaxException {
//        int itemid = addListItem.getItemid();
//        ListItemDTO listItemDTO = listItemService.findListitemByItemid(itemid);
//
//        if (listItemDTO != null) {
//            listItemService.deleteListitem((ListitemEntity) listItemDTO);
//        }
//        return (List<ListItemDTO>) listItemService.getAllItems();
//    }
}
