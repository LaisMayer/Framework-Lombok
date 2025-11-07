package br.edu.ifpr.cars.domain;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "é necessário digitar um nome" )
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres") 
    @Pattern(regexp = "^[\\S]+$", message = "O nome não pode conter espaços em branco")
    @Valid
    private String name;

    
    @NotBlank(message = "é necessário digitar um cpf" )
    @CPF(message = "O CPF é inválido ou não foi preenchido corretamente.") 
    private String email;

    @NotBlank(message = "é necessário digitar um email" )
    @Email(message = "O email deve estar no formato válido") 
    @Pattern(regexp = "^\\S+$", message = "O email não pode conter espaços em branco")
    private String cpf;
}
