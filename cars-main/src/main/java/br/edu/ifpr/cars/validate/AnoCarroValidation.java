package br.edu.ifpr.cars.validate;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnoCarroValidation implements ConstraintValidator<AnoCarro, Integer>{

    @Override
    public boolean isValid(Integer anoCarro, ConstraintValidatorContext context) {
       
       return anoCarro > 1886 && anoCarro < LocalDate.now().getYear();
    }
    
}
