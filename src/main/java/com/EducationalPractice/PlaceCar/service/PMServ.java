package com.EducationalPractice.PlaceCar.service;

import com.EducationalPractice.PlaceCar.entity.PM;
import com.EducationalPractice.PlaceCar.repository.PMRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class PMServ {
    private final PMRepo repo;
    public Optional<PM> getTitle(String ryadPM, String numberPM){ //Поменять
        return repo.findByRyadPMAndNumberPM(ryadPM, numberPM);
    }
    public List<PM> findAll(){
        return repo.findAll();
    }
    public Optional<PM> findById(Long id){
        return repo.findById(id);
    }
    public PM save(@Valid PM dataPM){
        return repo.save(dataPM);
    }
    public void update(@Valid PM dataPM){ //Под сомнением
        repo.save(dataPM);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public void deleteByRyadAndNumber(String ryadPM, String numberPM,Long idPM) {
        repo.deleteByRyadPMAndNumberPMAndIdPM(ryadPM,numberPM, idPM);
    }
}
