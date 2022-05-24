package com.example.aula04.repository;

import com.example.aula04.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

    
}
