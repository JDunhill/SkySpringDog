package com.sky.spring.dog.dtos;

import com.sky.spring.dog.domain.Dog;

import java.util.List;

public class HomeDTO {


    private int id;

    private String address;

    private List<Dog> dogs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
