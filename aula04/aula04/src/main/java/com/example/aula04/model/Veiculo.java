package com.example.aula04.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Long id;

    @NotBlank(message = "Preencha a placa")
    @Size(max = 7, message = "Tamanho inválido")
    @Column(nullable = false, length =7)
    private String placa;

    @NotBlank(message = "Preencha a marca")
    @Size(max = 30, message = "Tamanho inválido")
    @Column(nullable = false, length =30)
    private String marca;

    @NotBlank(message = "Preencha a modelo")
    @Size(max = 40, message = "Tamanho inválido")
    @Column(nullable = false, length =40)
    private String modelo;

    @Embedded
    private Caracteristica caracteristica;

	

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Caracteristica getCaracteristica() {
        return this.caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    @OneToOne
    @JoinColumn(name = "id_proprietario")
    private Proprietario proprietario;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "veiculo")
	private List<Manutencao> manutencoes;


    public List<Manutencao> getManutencoes() {
        return this.manutencoes;
    }

    public void setManutencoes(List<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }

}
