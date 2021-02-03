package cn.beichenhpy.unittestdemo.controller;

import cn.beichenhpy.unittestdemo.entity.Person;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class MockControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void mockGet() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/mock/get")
                        .param("mockParam", "1")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-Access-token", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding("UTF-8");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/mock/get")
                        .param("mockParam", "2")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-Access-token", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding("UTF-8");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/mock/get")
                        .param("mockParam", "3")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-Access-token", "1")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().setCharacterEncoding("UTF-8");
    }

    @Test
    void mockPost() throws Exception {
        Person person1 = new Person();
        Person person2 = new Person();
        person1.setAge(18);
        person2.setAge(17);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/mock/post")
                        .content(JSON.toJSONString(person1))
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-Access-token", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                //todo 这里设置为utf-8了还是不行
                .andReturn().getResponse().setCharacterEncoding("UTF-8");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/mock/post")
                        .content(JSON.toJSONString(person2))
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-Access-token", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
