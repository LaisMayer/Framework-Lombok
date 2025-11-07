package br.edu.ifpr.cars.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "é necessário digitar um nome" )
    @Valid
    String name;
    @NotBlank(message = "é necessário digitar um cpf" )
    String cpf;
    @NotBlank(message = "é necessário digitar um email" )
    String email;
    LocalDate birthDate;

}
