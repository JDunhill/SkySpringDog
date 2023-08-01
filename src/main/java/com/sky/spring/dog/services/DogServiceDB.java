package com.sky.spring.dog.services;

import com.sky.spring.dog.domain.Dog;
import com.sky.spring.dog.repos.DogRepo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class DogServiceDB implements DogService {

    private DogRepo repo;

    public DogServiceDB(DogRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Dog> create(List<Dog> newDogs) {
        return this.repo.saveAll(newDogs);
    }

    @Override
    public Dog create(Dog dog) {
        return this.repo.save(dog);
    }

    @Override
    public List<Dog> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Dog getById(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public Dog update(int id, String name, String colour, Integer age) {
        Dog toUpdate = this.getById(id);

        if(name != null) toUpdate.setName(name);
        if(colour != null) toUpdate.setColour(colour);
        if(age != null) toUpdate.setAge(age);

        return this.repo.save(toUpdate);
    }

    @Override
    public Dog remove(int id) {
        Dog delDog = this.getById(id);
        this.repo.deleteById(id);
        return delDog;
    }

    @Override
    public List<Dog> deleteByName(String name) {
        List<Dog> toDelete = this.repo.findByName(name);
        this.repo.deleteByName(name);
        return toDelete;
    }

}
