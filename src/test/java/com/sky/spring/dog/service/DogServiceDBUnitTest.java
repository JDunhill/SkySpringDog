package com.sky.spring.dog.service;

import com.sky.spring.dog.domain.Dog;
import com.sky.spring.dog.repos.DogRepo;
import com.sky.spring.dog.services.DogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DogServiceDBUnitTest {

    @Autowired
    private DogService service;

    @MockBean
    private DogRepo repo;

    @Test
    void testUpdate() {

        int id = 1;
        Dog existing = new Dog(id, "Dave", "Pink", 8);
        String name = "Bob";
        String colour = "Red";
        int age = 5;
        Dog updated = new Dog(id, name, colour, age);

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
        Mockito.when(this.repo.save(updated)).thenReturn(updated);

        Assertions.assertEquals(updated, this.service.update(id, name, colour, age));
    }

    @Test
    void testCreate() {

        Dog toCreate = new Dog("Dave", "Pink", 8);
        Mockito.when(this.repo.save(toCreate)).thenReturn(toCreate);

        Assertions.assertEquals(toCreate, this.service.create(toCreate));
    }

    @Test
    void testGetAll() {

        List<Dog> dogs = new ArrayList<>(List.of(new Dog("Dave", "blue", 9), new Dog("John", "green", 6), new Dog("Barry", "yellow", 5 )));

        Mockito.when(this.repo.findAll()).thenReturn(dogs);
        Assertions.assertEquals(dogs, this.service.getAll());
    }

    @Test
    void remove() {

        int id = 1;
        Dog toDelete = new Dog(id, "James", "orange", 9);
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(toDelete));
        Assertions.assertEquals(toDelete, this.service.remove(1));
    }
}




