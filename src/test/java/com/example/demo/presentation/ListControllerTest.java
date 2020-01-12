package com.example.demo.presentation;

import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.swing.*;

import static java.util.Collections.singletonList;

import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ListController.class)
class ListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListController listController;


    @Test
    void getLists() throws Exception{
        ListEntity listEntity = new ListEntity();
        listEntity.setOwner("3");
        listEntity.setListid(1);
        listEntity.setListname("test");

//        List<ListEntity> allLists = singletonList(listEntity);

        JSONObject res = new JSONObject();
        res.put("listname", listEntity.getListname());
        res.put("status",200);

        given(listController.getLists("3")).willReturn( res.toString() );

        MvcResult result= mockMvc.perform(get("/lists?owner=3")
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String str = result.getResponse().getContentAsString();
        System.out.println(str);

        assertThat(new JSONObject(str).get("listname")).isEqualTo(listEntity.getListname());


    }

    @Test
    void newList() throws Exception {
        ListsModel listsModel = new ListsModel();
        listsModel.setOwner("2");
        listsModel.setListid(2);
        listsModel.setListname("test2");

        JSONObject req = new JSONObject();
        req.put("listname", listsModel.getListname());


        JSONObject res = new JSONObject();
        res.put("listname", listsModel.getListname());
        res.put("status",200);

        given(listController.newList(listsModel)).willReturn( res.toString() );

        MvcResult result= mockMvc.perform(post("/addList")
                .content("{\"listname\":\"test2\"}")
                .contentType(APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String str = result.getResponse().getContentAsString();
        System.out.println(str);

        assertThat(new JSONObject(str).get("listname")).isEqualTo(listsModel.getListname());


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