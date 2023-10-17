package com.acme.trafficapi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.trafficapi.api.assembler.VeiculoAssembler;
import com.acme.trafficapi.api.model.VeiculoModel;
import com.acme.trafficapi.api.model.input.VeiculoInput;
import com.acme.trafficapi.domain.repository.VeiculoRepository;
import com.acme.trafficapi.domain.service.RegistroVeiculoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoAssembler veiculoAssembler;
    private RegistroVeiculoService registroVeiculoService;
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<VeiculoModel> listar() {
        return veiculoAssembler.toCollectionModel(veiculoRepository.findAll());
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<VeiculoModel> buscar(@PathVariable Long veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .map(veiculoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoModel cadastrar(@Valid @RequestBody VeiculoInput veiculoInput) {
        var veiculo = veiculoAssembler.toEntity(veiculoInput);
        return veiculoAssembler.toModel(registroVeiculoService.cadastrar(veiculo));
    }

}
