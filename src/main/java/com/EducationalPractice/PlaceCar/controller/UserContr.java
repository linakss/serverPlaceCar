package com.EducationalPractice.PlaceCar.controller;

import com.EducationalPractice.PlaceCar.entity.User;
import com.EducationalPractice.PlaceCar.response.BaseResp;
import com.EducationalPractice.PlaceCar.response.DataResp;
import com.EducationalPractice.PlaceCar.response.ListResp;
import com.EducationalPractice.PlaceCar.service.UserServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="Пользователи", description="Содержит методы для работы с пользователями ")
@RestController
@RequestMapping("educationalpractice/placecar/user")
@AllArgsConstructor
public class UserContr {
    private final UserServ service;
    @Operation(
            summary = "Вывод всех пользователей",
            description = "Позволяет вывести всех пользователей, что есть в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<ListResp<User>> getAll() {
        return ResponseEntity.ok(
                new ListResp<User>(true, "Список пользователей:", service.findAll()));
    }
    @Operation(
            summary = "Добавить пользователя",
            description = "Позволяет добавлять пользователя в базу"
    )
    @PostMapping("/save")
    public ResponseEntity<BaseResp> save(@RequestBody User user) {
        try {
            return ResponseEntity.ok(
                    new DataResp<User>(true, "Пользователь сохранен", service.save(user)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменить пользователя",
            description = "Позволяет редактировать и изменять пользователя"
    )
    @PutMapping("/update")
    public ResponseEntity<BaseResp> update(@RequestBody User user) {
        try {
            service.update(user);
            return ResponseEntity.ok(
                    new BaseResp(true, "Пользователь сохранен и обновлен"));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Удалить пользователя",
            description = "Позволяет удалить пользователя из базы"
    )
    @DeleteMapping("del/{id}")
    public ResponseEntity<BaseResp> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResp(true, "Пользователь удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<BaseResp> by_rec(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResp<User>(true, "Найден следующий ,бедолага",
                            service.findById(id).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
}
