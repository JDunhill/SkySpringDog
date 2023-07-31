package com.sky.spring.dog.services;

import com.sky.spring.dog.domain.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceDB implements DogService {

    @Override
    public List<Dog> create(List<Dog> newDogs) {
        return null;
    }

    @Override
    public Dog create(Dog dog) {
        return null;
    }

    @Override
    public List<Dog> getAll() {
        return null;
    }

    @Override
    public Dog getById(int id) {
        return null;
    }

    @Override
    public Dog update(int id, String name, String colour, Integer age) {
        return null;
    }

    @Override
    public Dog delete(int id) {
        return null;
    }
}
