package com.example.aula04.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.aula04.model.Veiculo;
import com.example.aula04.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping
    public Veiculo insert(@Valid @RequestBody Veiculo veiculo){
        return veiculoRepository.save(veiculo);        
    }

    @GetMapping
    public List<Veiculo> listar(){
        return veiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscar(@PathVariable Long id){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if(!veiculo.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(veiculo.get());
    }
}
