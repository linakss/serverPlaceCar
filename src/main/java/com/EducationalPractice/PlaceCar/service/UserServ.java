package com.EducationalPractice.PlaceCar.service;

import com.EducationalPractice.PlaceCar.entity.User;
import com.EducationalPractice.PlaceCar.repository.UserRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class UserServ {
    private final UserRepo repo;
    public List<User> findAll(){
        return repo.findAll();
    }
    public Optional<User> findById(Long id){
        return repo.findById(id);
    }
    public User save(@Valid User dataUser){ 
        return repo.save(dataUser);
    }
    public void update(@Valid User dataUser){ //Под сомнением
        repo.save(dataUser);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
