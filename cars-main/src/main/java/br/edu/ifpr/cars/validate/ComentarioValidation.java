package br.edu.ifpr.cars.validate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.mapping.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ComentarioValidation implements ConstraintValidator<Comentario, String>{

    private final ArrayList<String> PalavrasProibidas = (ArrayList<String>) Arrays.asList("burro","idiota", "lixo", "guardaroupa");

    @Override
    public boolean isValid(String comentario, ConstraintValidatorContext context) {

        if (comentario == null || comentario.trim().isEmpty()) {
            return true;
        }
        comentario = comentario.toLowerCase();

        for (String coment : PalavrasProibidas) {
           
            if (comentario.contains(coment)) {
               
                return false;
            }
        }
        return true;
    }
    
}
