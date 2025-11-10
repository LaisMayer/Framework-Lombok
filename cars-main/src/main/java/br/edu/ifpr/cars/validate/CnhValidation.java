package br.edu.ifpr.cars.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CnhValidation implements ConstraintValidator<Cnh, String>{

    private static final String CNH = "\\d{11}";

    @Override
    public boolean isValid(String cnh, ConstraintValidatorContext context) {
        if (cnh == null || cnh.trim().isEmpty()) {
            return true;
        }
        return cnh.matches(CNH);
    }
}