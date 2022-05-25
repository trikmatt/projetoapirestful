package com.example.aula04.enums;

import com.example.aula04.exception.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum Combustivel {
    GASOLINA(1,"Gasolina"), ALCOOL(2, "Álcool"), DIESEL(3, "Diesel"), FLEX(4, "Flex");

    private Integer codigo;
    private String tipoCombustivel;

    private Combustivel(Integer codigo, String tipoCombustivel) {
		this.codigo = codigo;
		this.tipoCombustivel = tipoCombustivel;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}	

    @JsonCreator
    public static Combustivel verificarCombustivel(Integer value) throws EnumValidationException {
        for (Combustivel combustivel : Combustivel.values()){
            if(value.equals(combustivel.getCodigo())){
                return combustivel;
            }
        }
        throw new EnumValidationException("Combustivel inválida");
    }
	
}
