package com.sky.spring.dog.rest;


import com.sky.spring.dog.domain.Dog;
import com.sky.spring.dog.services.DogService;
import com.sky.spring.dog.services.DogServiceList;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {

    private DogService service;

    public DogController(DogService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Dog> create(@RequestBody @Validated Dog dog) {
        return new ResponseEntity<>(this.service.create(dog), HttpStatus.CREATED);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<Dog>> create(@RequestBody List<Dog> newDogs) {
        System.out.println("RECEIVED. Added: " + newDogs.size() + " dogs.");
        if (this.service.create(newDogs) != null) {

            return new ResponseEntity<>(newDogs, HttpStatus.CREATED);
        } else {
            return  ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/getAll")
    public List<Dog> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/get/{id}")
    public Dog getById(@PathVariable int id) {
        return this.service.getById(id);
    }

   @PatchMapping("/update/{id}")
    public Dog update(@PathVariable int id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "colour", required = false) String colour, @RequestParam(value = "age", required = false) Integer age) {
        return this.service.update(id, name, colour, age);
   }

   @DeleteMapping("/delete/{id}")
    public Dog remove(@PathVariable int id) {
       return this.service.remove(id);
   }

   @DeleteMapping("/deleteByName/{name}")
    public List<Dog> deleteByName(@PathVariable String name) {
        return this.service.deleteByName(name);
   }






}
