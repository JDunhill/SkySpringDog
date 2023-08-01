package com.sky.spring.dog.services;

import com.sky.spring.dog.domain.Dog;

import java.util.List;

public interface DogService {



    Dog create(Dog dog);

    List<Dog> create(List<Dog> newDogs);

    List<Dog> getAll();

    Dog getById(int id);

    Dog update(int id, String name, String colour, Integer age);

    Dog remove(int id);

    List<Dog> deleteByName(String name);


}
