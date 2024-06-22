package com.EducationalPractice.PlaceCar.repository;
import com.EducationalPractice.PlaceCar.entity.Car;
import com.EducationalPractice.PlaceCar.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByLoginAndPassword(String login, String password);

}

