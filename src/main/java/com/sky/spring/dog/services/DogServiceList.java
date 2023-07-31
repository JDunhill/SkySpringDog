package com.sky.spring.dog.services;

import com.sky.spring.dog.domain.Dog;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class DogServiceList implements DogService {

    private List<Dog> dogs = new ArrayList<>();

    @Override
    public Dog create(Dog dog) {
        System.out.println("RECEIVED: " + dog);
        this.dogs.add(dog);
        Dog created = this.dogs.get(this.dogs.size() - 1);
        return created;
    }


    @Override
    public List<Dog> create(List<Dog> newDogs) {
        this.dogs.addAll(newDogs);
        return newDogs;
    }

    @Override
    public List<Dog> getAll() {
        System.out.println(this.dogs);
        return this.dogs;
    }

    @Override
    public Dog getById(int id) {
        System.out.println("ID: " + id);
        System.out.println(this.dogs.get(id));
        return this.dogs.get(id);
    }

    @Override
    public Dog update(int id, String name, String colour, Integer age) {
        Dog toUpdate = this.dogs.get(id);
        toUpdate.setName(name);
        toUpdate.setAge(age);
        toUpdate.setColour(colour);
        System.out.println("UPDATE: Dog ID: " + id + " was updated. It is now: " + this.dogs.get(id) + ".");
        return dogs.get(id);

    }

    @Override
    public Dog delete(int id) {
        System.out.println("DELETED. Dog at ID: " + id + " was deleted.");
        return this.dogs.remove(id);
    }



}
