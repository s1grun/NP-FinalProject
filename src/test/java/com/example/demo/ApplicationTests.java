package com.example.demo;

import com.example.demo.presentation.ListController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
class DemoApplicationTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Before
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(new ListController()).build();

//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
//    @Test
//    void contextLoads() {
//    }

}
