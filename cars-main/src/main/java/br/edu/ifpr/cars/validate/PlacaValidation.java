package br.edu.ifpr.cars.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidation implements ConstraintValidator<Placa, String> {

    private static final String PLACA_MERCOSUL_REGEX = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$";

    @Override
    public boolean isValid(String placa, ConstraintValidatorContext context) {
        if (placa == null || placa.isEmpty()) {
            return true;
        }
        return placa.matches(PLACA_MERCOSUL_REGEX);
    }
    
}
