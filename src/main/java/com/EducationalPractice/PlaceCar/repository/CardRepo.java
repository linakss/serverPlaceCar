package com.EducationalPractice.PlaceCar.repository;

import com.EducationalPractice.PlaceCar.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepo extends JpaRepository<Card, Long>  {
}

