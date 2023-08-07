package com.sky.spring.dog.services;

import com.sky.spring.dog.domain.Dog;
import com.sky.spring.dog.domain.Home;
import com.sky.spring.dog.dtos.DogDTO;
import com.sky.spring.dog.dtos.HomeDTO;
import com.sky.spring.dog.repos.HomeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    private HomeRepo repo;

    public HomeService(HomeRepo repo) {
        this.repo = repo;
    }

    public Home create(Home home) {
        return this.repo.save(home);
    }

    public List<Home> create(List<Home> homes) {
        return this.repo.saveAll(homes);
    }

    public List<HomeDTO> getAll() {

        List<Home> homes = this.repo.findAll();

        List<HomeDTO> dtos = new ArrayList<>();
        for(Home h : homes) {
            HomeDTO dto = new HomeDTO();
            dto.setId(h.getId());
            dto.setAddress(h.getAddress());

            List<DogDTO> doggies = new ArrayList<>();
            for (Dog d : h.getDogs()) {
                DogDTO dDto = new DogDTO();
                dDto.setId(d.getId());
                dDto.setName(d.getName());
                dDto.setColour(d.getColour());
                dDto.setAge(d.getAge());
                doggies.add(dDto);
            }
            dtos.add(dto);
        }
        return dtos;
    }

    public Home getById(int id) {
        Home actualHome = this.repo.findById(id).get();

        return actualHome;
    }

    public Home update(int id, String address) {
        Home toUpdate = this.getById(id);
        if (address != null) toUpdate.setAddress(address);

        return this.repo.save(toUpdate);

    }

    public Home remove(int id) {
        Home toDelete = this.getById(id);
        this.repo.deleteById(id);
        return toDelete;
    }

}
