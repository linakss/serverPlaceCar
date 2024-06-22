package com.EducationalPractice.PlaceCar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
@Schema(description = "Инфа о банк.карте")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCard; //индивид. номер карты гостя в базе
    @NotBlank()
    @Pattern(regexp = "[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}")
    @Schema(description = "Номер банковской карты ", example = "1234 5678 9101 2345")
    private String numberCard; // номер банковской карты
    @NotBlank()
    @Pattern(regexp = "[0-9]{2}/[0-9]{2}")
    @Schema(description = "Срок действия карты ", example = "01/25")
    private String termCard; // срок действия карты
    @NotBlank()
    @Pattern(regexp = "[А-Я][а-я]{1,30}")
    @Schema(description = "Банк ", example = "Сбербанк")
    private String bankCard; // банк карты гостя
    @NotBlank()
    @Pattern(regexp = "[A-Z]{1,20}\\s[A-Z]{1,20}")
    @Schema(description = "ФИО гостя ЛАТИНИЦЕЙ ", example = "MAKSIM AVERIANOV")
    private String nameCard; // имя и фамилия гостя ЛАТИНИЦЕЙ
    @NotBlank()
    @Pattern(regexp = "[0-9]{3}")
    @Schema(description = "CVV-код ", example = "123")
    private String cvvCard; // cvv-код на оборотной стороне карты
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<PM> pmList;


}
