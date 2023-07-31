package com.sky.spring.dog.rest;


import com.sky.spring.dog.domain.Dog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {

    private List<Dog> dogs = new ArrayList<>();

    /*@GetMapping("/hello")
    public String hello() {
        return "Hello, World";
    }*/

    @PostMapping("/create")
    public Dog create(@RequestBody Dog dog) {

        System.out.println("RECEIVED: " + dog);
        this.dogs.add(dog);
        return this.dogs.get(this.dogs.size() - 1);
    }

    @PostMapping("/createMultiple")
    public List<Dog> create(@RequestBody List<Dog> newDogs) {
        for(Dog dog : newDogs) {
            this.dogs.add(dog);
        }
        System.out.println("RECEIVED. Added: " + this.dogs.size() + " dogs.");
        return this.dogs;
    }


    @GetMapping("/getAll")
    public List<Dog> getAll() {
        System.out.println(this.dogs);
        return this.dogs;
    }

    @GetMapping("/get/{id}")
    public Dog getById(@PathVariable Integer id) {
        System.out.println("ID: " + id);
        System.out.println(this.dogs.get(id));
        return this.dogs.get(id);
    }

  /* @PatchMapping("/update/{id}")
    public Dog update(
            @PathVariable Integer id,
            @PathParam("name") String name,
            @PathParam("colour") String colour,
            @PathParam("age") Integer age) {}*/




}
