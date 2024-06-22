package com.EducationalPractice.PlaceCar.service;

import com.EducationalPractice.PlaceCar.entity.Car;
import com.EducationalPractice.PlaceCar.entity.Car;
import com.EducationalPractice.PlaceCar.entity.User;
import com.EducationalPractice.PlaceCar.repository.CarRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class CarServ {
    private final CarRepo repo;
    public List<Car> getGosNumber(String gosNumber){ //Поменять
        return repo.findByGosNumberCar(gosNumber);
    }
    public List<Car> findAll(){
        return repo.findAll();
    }
    public Optional<Car> findById(Long id){
        return repo.findById(id);
    }
    public Car save(@Valid Car dataCar){
        return repo.save(dataCar);
    }
    public void update(@Valid Car dataCar){ //Под сомнением
        repo.save(dataCar);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }

}

