package com.example.demo.presentation;

import com.example.demo.domain.ListDTO;
import com.example.demo.domain.ListEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.*;

import static java.util.Collections.singletonList;

import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)
//@WebMvcTest(ListController.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ListControllerTest {

//    @Autowired
//    private WebApplicationContext webApp;
    @Autowired
    private MockMvc mockMvc;

//    @MockBean
    private ListController listController;

//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApp).build();
//    }


    @Test
    void testTest() throws Exception {
        mockMvc.perform(get("/test").accept(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void testLists() throws Exception{
        MvcResult result= mockMvc.perform(get("/lists")
                .contentType(TEXT_PLAIN)
                .content("{\"owner\":\"2\"}")
                .param("owner","2")
                .accept(APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String str = result.getResponse().getContentAsString();
        System.out.println(str);

    }

    @Test
    void testNewList() throws Exception {
        ListsModel listsModel = new ListsModel();
        listsModel.setOwner("2");
//        listsModel.setListid(2);
        listsModel.setListname("test2");


//        given(listController.newList(listsModel)).willReturn( res.toString() );

        MvcResult result= mockMvc.perform(post("/addList")
                .contentType(APPLICATION_JSON)
//                .content(JSON.toJSONString(listsModel))
                .accept(TEXT_PLAIN)
                .content("{\"listname\":\"test2\",\"owner\":\"2\"}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String str = result.getResponse().getContentAsString();
        System.out.println(str);
        assertThat(new JSONObject(str).get("listname")).isEqualTo(listsModel.getListname());


    }

    @Test
    void testDeleteList() throws Exception {
        MvcResult result= mockMvc.perform(post("/deleteList")
                        .contentType(APPLICATION_JSON)
//                .content(JSON.toJSONString(listsModel))
                        .accept(TEXT_PLAIN)
                        .content("{\"listid\":\"35\"}")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
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