package com.EducationalPractice.PlaceCar.controller;

import com.EducationalPractice.PlaceCar.entity.Employee;
import com.EducationalPractice.PlaceCar.response.BaseResp;
import com.EducationalPractice.PlaceCar.response.DataResp;
import com.EducationalPractice.PlaceCar.response.ListResp;
import com.EducationalPractice.PlaceCar.service.EmployeeServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Сотрудники", description="Содержит методы для работы с сотрудниками")
@RestController
@RequestMapping("educationalpractice/placecar/employee")
@AllArgsConstructor
public class EmployeeContr {
    private final EmployeeServ service;
    @Operation(
            summary = "Вывод всех сотрудников",
            description = "Позволяет вывести всех сотрудников, что есть в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<ListResp<Employee>> getAll() {
        return ResponseEntity.ok(
                new ListResp<Employee>(true, "Список сотрудников:", service.findAll()));
    }
    @Operation(
            summary = "Добавить сотрудника",
            description = "Позволяет добавлять сотрудника в базу"
    )
    @PostMapping("/save")
    public ResponseEntity<BaseResp> save(@RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(
                    new DataResp<Employee>(true, "Сотрудник сохранен", service.save(employee)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменить сотрудника",
            description = "Позволяет редактировать и изменять сотрудника"
    )
    @PutMapping("/update")
    public ResponseEntity<BaseResp> update(@RequestBody Employee employee) {
        try {
            service.update(employee);
            return ResponseEntity.ok(
                    new BaseResp(true, "Сотрудник сохранен и обновлен"));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }

    @Operation(
            summary = "Удалить сотрудника",
            description = "Позволяет удалить сотрудника из базы"
    )
    @DeleteMapping("del/{id}")
    public ResponseEntity<BaseResp> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResp(true, "Сотрудник удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
    @GetMapping("/check")
    public ResponseEntity<BaseResp> check(@RequestParam String login, @RequestParam String password) {
        try {
            return ResponseEntity.ok(
                    new DataResp<Employee>(true, "Найден следующий пользователь ",
                            service.checkEmployee(login,password).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
}
