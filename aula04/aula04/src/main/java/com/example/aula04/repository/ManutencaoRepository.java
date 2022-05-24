package com.example.aula04.repository;

import com.example.aula04.model.Manutencao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{
    
}
