package com.sky.spring.dog.repos;

import com.sky.spring.dog.domain.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends JpaRepository<Home, Integer> {




}
