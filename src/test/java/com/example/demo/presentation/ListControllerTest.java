package com.example.demo.presentation;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static java.util.Collections.singletonList;
import javax.swing.*;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ListController.class)
class ListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListController listController;


    @Test
    void getLists() throws Exception{
        AddLists addLists = new AddLists();
        addLists.setOwner("john");
        addLists.setListid(1);
        addLists.setListname("test");

        List<AddLists> allLists = singletonList(addLists);

        JSONObject res = new JSONObject();
        res.put("data", allLists.toString() );
        res.put("status",200);
//        res.put("locations",locationService.getAllLocations());



        given(listController.getLists(addLists.getOwner())).willReturn( res.toString() );

        MvcResult result= mockMvc.perform(get("/lists?owner=john")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String str = result.getResponse().getContentAsString();
        System.out.println(str);

        assertThat(new JSONObject(str).get("data")).isEqualTo(addLists.getListname());


    }

    @Test
    void newList() {
    }

    @Test
    void getListItems() {
    }

    @Test
    void newListItem() {
    }

    @Test
    void updateListItem() {
    }

    @Test
    void deleteListItem() {
    }
}