package com.example.aula04.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.aula04.model.Manutencao;
import com.example.aula04.repository.ManutencaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {
    @Autowired
    private ManutencaoRepository manutencaoRepository;  

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manutencao inserir(@Valid @RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }
    @GetMapping
    public List<Manutencao> listar(){
        return manutencaoRepository.findAll();
    }
}
