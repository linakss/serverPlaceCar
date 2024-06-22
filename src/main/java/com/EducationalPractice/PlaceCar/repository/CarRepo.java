package com.EducationalPractice.PlaceCar.repository;

import com.EducationalPractice.PlaceCar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepo extends JpaRepository<Car, Long>  {
    List<Car> findByGosNumberCar(String gosNumber);
}

