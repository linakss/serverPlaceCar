package com.EducationalPractice.PlaceCar.controller;

import com.EducationalPractice.PlaceCar.entity.PM;
import com.EducationalPractice.PlaceCar.response.BaseResp;
import com.EducationalPractice.PlaceCar.response.DataResp;
import com.EducationalPractice.PlaceCar.response.ListResp;
import com.EducationalPractice.PlaceCar.service.PMServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Парковочные места", description="Содержит методы для работы с парковочными местами ")
@RestController
@RequestMapping("educationalpractice/placecar/pm")
@AllArgsConstructor
public class PMContr {
    private final PMServ service;
    @Operation(
            summary = "Вывод всех парковочных мест",
            description = "Позволяет вывести все парковочных места, что есть в базе"
    )
    @GetMapping("/all")
    public ResponseEntity<ListResp<PM>> getAll() {
        return ResponseEntity.ok(
                new ListResp<PM>(true, "Список парковочных мест:", service.findAll()));
    }
    @Operation(
            summary = "Добавить парковочное место",
            description = "Позволяет добавлять парковочное место в базу"
    )
    @PostMapping("/save")
    public ResponseEntity<BaseResp> save(@RequestBody PM pm) {
        try {
            return ResponseEntity.ok(
                    new DataResp<PM>(true, "Парковочное место сохранено", service.save(pm)));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
    @Operation(
            summary = "Изменить парковочное место",
            description = "Позволяет редактировать и изменять парковочное место"
    )
    @PutMapping("/update")
    public ResponseEntity<BaseResp> update(@RequestBody PM pm) {
        try {
            service.update(pm);
            return ResponseEntity.ok(
                    new BaseResp(true, "Парковочное место сохранено и обновлено"));
        }catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }


//    @DeleteMapping("del/{ryadPM}/{numberPM}/{idPM}")
//    public ResponseEntity<BaseResp> delete(@PathVariable String ryadPM, @PathVariable String numberPM,@PathVariable Long idPM ) {
//        try {
//            service.deleteByRyadAndNumber(ryadPM, numberPM,idPM);
//            return ResponseEntity.ok(
//                    new BaseResp(true, "Парковочное место удалено"));
//        } catch (RuntimeException e) {
//            return ResponseEntity.ok(
//                    new BaseResp(false, e.getMessage()));
//        }
//    }
    @Operation(
            summary = "Удалить парковочное место",
            description = "Позволяет удалить парковочное место из базы"
    )
    @DeleteMapping("del/{id}")
    public ResponseEntity<BaseResp> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResp(true, "Парковочное место удалено"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));

        }
    }
    @GetMapping
    public ResponseEntity<BaseResp> check(@RequestParam String ryadPM, @RequestParam String numberPM ) {
        try {
            return ResponseEntity.ok(
                    new DataResp<PM>(true, "Найдено следующее , парковачное место: ",
                            service.getTitle(ryadPM,numberPM)   .orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResp(false, e.getMessage()));
        }
    }
}
