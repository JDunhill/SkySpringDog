package com.sky.spring.dog.domain;

//import com.sky.spring.dog.annotations.ValidateString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Dog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

//    @ValidateString(acceptedValues={"Brown", "Merle", "Gold", "Black"} )
    private String colour;

    @Range(min = 0, max = 32)
    private Integer age;

    @ManyToOne(targetEntity = Home.class)
    private Home home;


    public Dog(Integer id, String name, String colour, Integer age) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.age = age;
    }

    public Dog(String name, String colour, Integer age, Home home) {
        this.name = name;
        this.colour = colour;
        this.age = age;
        this.home = home;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(id, dog.id) && Objects.equals(name, dog.name) && Objects.equals(colour, dog.colour) && Objects.equals(age, dog.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, colour, age);
    }
}
