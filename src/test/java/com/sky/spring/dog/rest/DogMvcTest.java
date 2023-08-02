package com.sky.spring.dog.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.spring.dog.domain.Dog;
import org.aspectj.weaver.ast.And;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:sql-schema.sql", "classpath:dog-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DogMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        Dog bjorn = new Dog("Bjorn", "merle", 1);
        System.out.println("DATA: " + bjorn);
        String bjornJSON = this.mapper.writeValueAsString(bjorn);
        System.out.println("JSON: " + bjornJSON);
        RequestBuilder req = MockMvcRequestBuilders.post("/dog/create").content(bjornJSON).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        Dog responseBody = new Dog(2, "Bjorn", "merle", 1);
        System.out.println("DATA: " + responseBody);
        String responseBodyJSON = this.mapper.writeValueAsString(responseBody);
        System.out.println("JSON: " + responseBodyJSON);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(responseBodyJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
    @Test
    void testCreate2() throws Exception {
        String dogJSON = this.mapper.writeValueAsString(new Dog( "Tom", "black", 8));
        String responseBodyJSON = this.mapper.writeValueAsString(new Dog(2, "Tom", "black", 8));
        this.mvc.perform(
                        MockMvcRequestBuilders.
                                post("/dog/create")
                                .content(dogJSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(responseBodyJSON));

    }

    @Test
    void testRead() throws Exception {
        final int id = 1;
        String responseBody = this.mapper.writeValueAsString(new Dog(id, "Ben", "grey", 4));
        this.mvc.perform(get("/dog/get/" + id))
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody));
    }

    @Test
    void testReadAll() throws Exception {

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1, "Ben", "grey", 4));
        String responseBody = this.mapper.writeValueAsString(dogs);
        this.mvc.perform(get("/dog/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody));
    }

    @Test
    void testDeleteByName() throws Exception {
        final String toDelete = "Ben";
       List<Dog> dogs = new ArrayList<>();
       dogs.add(new Dog(1, "Ben", "grey", 4));
      String responseBody = this.mapper.writeValueAsString(dogs);
//        String responseBody = this.mapper.writeValueAsString(new Dog( "Ben", "grey", 4));
        this.mvc.perform(delete("/dog/deleteByName/Ben")).andExpect(status().isOk()).andExpect(content().json(responseBody));

    }
    @Test
    void testRemove() throws Exception {
        final int id = 1;
        String responseBody = this.mapper.writeValueAsString(new Dog(id, "Ben", "grey", 4));
        this.mvc.perform(delete("/dog/delete/" + id)).andExpect(status().isOk()).andExpect(content().json(responseBody));
    }



    @Test
    void testUpdate() throws Exception {
        final int id = 1;
        final String name = "Jordan";
        final String colour = "blonde";
        final int age = 2;
        String responseBodyJSON = this.mapper.writeValueAsString(new Dog(id, "Jordan", "blonde", 2));
        this.mvc.perform(
                MockMvcRequestBuilders
                        .patch("/dog/update/" + id +
                                "?name=" + name +
                                "&colour=" + colour +
                                "&age=" + 2))


                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseBodyJSON));



    }






}
