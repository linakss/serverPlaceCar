package com.EducationalPractice.PlaceCar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Schema(description = "Инфа о госте парковки")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser; //индивид. номер гостя парковки
    @Schema(description = "Время въезда ", example = "dd-MM-yyyy HH:mm")
    private String timeEntry; //Время въезда
    @Schema(description = "Время выезда ", example = "dd-MM-yyyy HH:mm")
    private String timeDeparture; //Время выезда
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Override
    public String toString() {
        return "";
    }
}




    /*
    import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;

LocalDateTime startTime = LocalDateTime.of(timeEntry);
LocalDateTime endTime = LocalDateTime.of(timeDeparture);

Duration продолжительность = Duration.between(startTime, endTime);
Period период = Period.between(startTime.toLocalDate(), endTime.toLocalDate());
     */