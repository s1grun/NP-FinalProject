package com.example.demo.presentation;

import com.example.demo.application.ListService;
import com.example.demo.application.UserService;
import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListEntity;
import com.example.demo.domain.UserEntity;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import org.springframework.ui.Model;

import java.util.List;

@RestController
public class ListController {
    @Autowired
    private UserService userService;
    @Autowired
    private ListService listService;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid UserEntity userEntity, BindingResult result, Model model) throws Exception{
        UserEntity userloggedIn = null;
        try {
            userloggedIn = userService.login(userEntity);
        } catch (Exception ex) {
            throw new Exception();
        }

        model.addAttribute("username", userloggedIn.getName());
        model.addAttribute("userId", userloggedIn.getUserId());

        return returnTo("list-view", model);
    }

    @PostMapping("/lists")
    public String lists(ListEntity listEntity, Model model){
        List<? extends ListDTO> allLists = listService.getAllLists();
        model.addAttribute("to-do list", allLists);
        return "index";
    }

    private String returnTo(String page, Model model){
        return "index";
    }

}
