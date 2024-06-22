package com.EducationalPractice.PlaceCar.repository;

import com.EducationalPractice.PlaceCar.entity.Car;
import com.EducationalPractice.PlaceCar.entity.PM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface PMRepo extends JpaRepository<PM, Long>  {
    Optional<PM> findByRyadPMAndNumberPM(String ryadPM, String numberPM);
    void deleteByRyadPMAndNumberPMAndIdPM(String ryadPM, String numberPM,Long idPM);
}

