package com.example.aula04.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.aula04.model.Proprietario;
import com.example.aula04.repository.ProprietarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {
    @Autowired
    private ProprietarioRepository proprietarioRepository;  

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario inserir(@Valid @RequestBody Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }
    
	@GetMapping
    public List<Proprietario> listar(){
        return proprietarioRepository.findAll();
    }
}

