package com.EducationalPractice.PlaceCar.controller;

import com.EducationalPractice.PlaceCar.entity.Card;
import com.EducationalPractice.PlaceCar.entity.Employee;
import com.EducationalPractice.PlaceCar.response.BaseResp;
import com.EducationalPractice.PlaceCar.response.DataResp;
import com.EducationalPractice.PlaceCar.response.ListResp;
import com.EducationalPractice.PlaceCar.service.CardServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Карты", description="Содержит методы для работы с картами")
@RestController
@RequestMapping("educationalpractice/placecar/card")
@AllArgsConstructor
public class CardContr {
    private final CardServ service;
    @Operation(

            summary = "Вывод всех карт",
            description = "Позволяет вывести все карты, что есть в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<ListResp<Card>> getAll() {
        return ResponseEntity.ok(
                new ListResp<Card>(true, "Список карт:", service.findAll()));
    }

    @Operation(
            summary = "Добавить карту",
            description = "Позволяет добавлять карту в базу"
    )
    @PostMapping("/save")
    public ResponseEntity<BaseResp> save(@RequestBody Card card) {
        try {
            return ResponseEntity.ok(
                    new DataResp<Card>(true, "Карта сохранена", service.save(card)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
    @GetMapping// Работает
    public ResponseEntity<BaseResp> by_rec(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResp<Card>(true, "Найден следующий ,бедолага",
                            service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменить карту",
            description = "Позволяет редактировать и изменять карту"
    )
    @PutMapping("/update")
    public ResponseEntity<BaseResp> update(@RequestBody Card card) {
        try {
            service.update(card);
            return ResponseEntity.ok(
                    new BaseResp(true, "Карта сохранена и обновлена"));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));

        }
    }
    @Operation(
            summary = "Удалить карту",
            description = "Позволяет удалить карту из базы"
    )
    @DeleteMapping("del/{id}")
    public ResponseEntity<BaseResp> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResp(true, "Карта удалена"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
}
