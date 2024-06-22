package com.EducationalPractice.PlaceCar.service;

import com.EducationalPractice.PlaceCar.entity.Card;
import com.EducationalPractice.PlaceCar.repository.CardRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class CardServ {
    private final CardRepo repo;
    public List<Card> findAll(){
        return repo.findAll();
    }
    public Optional<Card> findById(Long id){
        return repo.findById(id);
    }
    public Card save(@Valid Card dataCard){
        return repo.save(dataCard);
    }
    public void update(@Valid Card dataCard){ //Под сомнением
        repo.save(dataCard);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}

