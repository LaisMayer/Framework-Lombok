package br.edu.ifpr.cars.domain;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import br.edu.ifpr.cars.validate.AnoCarro;
import br.edu.ifpr.cars.validate.Cnh;
import br.edu.ifpr.cars.validate.Comentario;
import br.edu.ifpr.cars.validate.Impar;
import br.edu.ifpr.cars.validate.Placa;
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

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "é necessário digitar um nome" )
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres") 
    @Pattern(regexp = "^[\\S]+$", message = "O nome não pode conter espaços em branco")
    @Valid
    String name; 

    @NotBlank(message = "é necessário digitar um cpf" )
    @CPF(message = "O CPF é inválido ou não foi preenchido corretamente.") 
    String cpf;

    @NotBlank(message = "é necessário digitar um email" )
    @Email(message = "O email deve estar no formato válido") 
    @Pattern(regexp = "^\\S+$", message = "O email não pode conter espaços em branco")
    String email;
    
    LocalDate birthDate;

    @Placa
    String placa;
    @Cnh
    String cnh;
    @AnoCarro
    int anoCarro;
    @Comentario
    String comentario;
    @Impar
    int num;

}
