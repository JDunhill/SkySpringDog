package com.sky.spring.dog.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.spring.dog.domain.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        Dog bjorn = new Dog(1, "Bjorn", "merle", 1);
        System.out.println("DATA: " + bjorn);
        String bjornJSON = this.mapper.writeValueAsString(bjorn);
        System.out.println("JSON: " + bjornJSON);
        RequestBuilder req = MockMvcRequestBuilders.post("/dog/create").content(bjornJSON).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        Dog responseBody = new Dog(1, "Bjorn", "merle", 1);
        System.out.println("DATA: " + responseBody);
        String responseBodyJSON = this.mapper.writeValueAsString(responseBody);
        System.out.println("JSON: " + responseBodyJSON);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(responseBodyJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
    @Test
    void testCreate2() throws Exception {
        String dogJSON = this.mapper.writeValueAsString(new Dog(1, "Tom", "black", 8));
        String responseBodyJSON = this.mapper.writeValueAsString(new Dog(1, "Tom", "black", 8));
        this.mvc.perform(
                        MockMvcRequestBuilders.
                                post("/dog/create")
                                .content(dogJSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(responseBodyJSON));

    }






}
