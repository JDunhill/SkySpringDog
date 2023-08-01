package com.sky.spring.dog.repos;

import com.sky.spring.dog.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DogRepo extends JpaRepository<Dog, Integer> {

    List<Dog> findByName(String name);

    int deleteByName(String name);

}
