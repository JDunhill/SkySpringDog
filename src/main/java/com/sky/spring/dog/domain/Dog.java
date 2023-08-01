package com.sky.spring.dog.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String colour;

    @Range(min = 0, max = 32)
    private Integer age;



    public Dog(String name, String colour, Integer age) {
        this.name = name;
        this.colour = colour;
        this.age = age;
    }

    // REQUIRED default constructor
    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", age=" + age +
                '}';
    }
}
