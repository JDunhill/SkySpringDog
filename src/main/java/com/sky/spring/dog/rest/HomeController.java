package com.sky.spring.dog.rest;

import com.sky.spring.dog.domain.Home;
import com.sky.spring.dog.domain.Home;
import com.sky.spring.dog.dtos.HomeDTO;
import com.sky.spring.dog.services.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    private HomeService service;

    public HomeController(HomeService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Home> create(@RequestBody @Validated Home home) {
        return new ResponseEntity<>(this.service.create(home), HttpStatus.CREATED);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<Home>> create(@RequestBody List<Home> newHomes) {
        System.out.println("RECEIVED. Added: " + newHomes.size() + " dogs.");
        if (this.service.create(newHomes) != null) {

            return new ResponseEntity<>(newHomes, HttpStatus.CREATED);
        } else {
            return  ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/getAll")
    public List<HomeDTO> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/get/{id}")
    public Home getById(@PathVariable int id) {
        return this.service.getById(id);
    }

    @PatchMapping("/update/{id}")
    public Home update(@PathVariable int id, @RequestParam(value = "address", required = false) String address) {
        return this.service.update(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public Home remove(@PathVariable int id) {
        return this.service.remove(id);
    }





}
