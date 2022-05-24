package com.example.aula04.enums;

import com.example.aula04.exception.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {
    HATCH, SEDAN, PICAPE, SUV, CONVERSIVEL, MINIVAN;

    @JsonCreator
    public static Categoria verificCategoria(String value) throws EnumValidationException {
        for (Categoria categoria : Categoria.values()){
            if(value.equals(categoria.name())){
                return categoria;
            }
        }
        throw new EnumValidationException("Categoria inválida");
    }
}
