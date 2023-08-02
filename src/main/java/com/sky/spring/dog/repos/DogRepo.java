package com.sky.spring.dog.repos;

import com.sky.spring.dog.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DogRepo extends JpaRepository<Dog, Integer> {

    List<Dog> findByName(String name);

    @Modifying
    int deleteByName(String name);

}
