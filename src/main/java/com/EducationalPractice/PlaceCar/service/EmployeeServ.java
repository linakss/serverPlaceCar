package com.EducationalPractice.PlaceCar.service;


import com.EducationalPractice.PlaceCar.entity.Employee;
import com.EducationalPractice.PlaceCar.entity.User;
import com.EducationalPractice.PlaceCar.repository.EmployeeRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class EmployeeServ {
    private final EmployeeRepo repo;
    public List<Employee> findAll(){
        return repo.findAll();
    }
    public Optional<Employee> findById(Long id){
        return repo.findById(id);
    }
    public Employee save(@Valid Employee dataEmployee){
        return repo.save(dataEmployee);
    }
    public void update(@Valid Employee dataEmployee){
        repo.save(dataEmployee);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Optional<Employee> checkEmployee(String login, String password) {
        return repo.findByLoginAndPassword(login, password);
    }
    
}

