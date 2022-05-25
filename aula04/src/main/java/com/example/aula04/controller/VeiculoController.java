package com.example.aula04.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.aula04.model.Veiculo;
import com.example.aula04.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Inserir um novo veículo", notes = "Inserir")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna todos os veículos"),
			@ApiResponse(code = 401 , message = "Não autorizado"),
			@ApiResponse(code = 403, message = "Proibido acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
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
