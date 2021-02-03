package cn.beichenhpy.unittestdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class MockControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void mockGet() throws Exception {
        MvcResult mock_1 = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/mock/get")
                        .param("mockParam","1")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-Access-token","1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("mock_1"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        MvcResult mock_2 = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/mock/get")
                        .param("mockParam","2")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-Access-token","1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("mock_2"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        MvcResult mockGet = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/mock/get")
                        .param("mockParam","3")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-Access-token","1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("mockGet"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
