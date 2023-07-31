package com.sky.spring.dog.domain;

public class Dog {

    private String name;

    private String colour;

    private int age;


    public Dog(String name, String colour, int age) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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