package com.acme.trafficapi.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.trafficapi.api.assembler.AutuacaoAssembler;
import com.acme.trafficapi.api.model.AutuacaoModel;
import com.acme.trafficapi.api.model.input.AutuacaoInput;
import com.acme.trafficapi.domain.service.RegistroAutuacaoService;
import com.acme.trafficapi.domain.service.RegistroVeiculoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {
    private final AutuacaoAssembler autuacaoAssembler;
    private final RegistroAutuacaoService registroAutuacaoService;
    private final RegistroVeiculoService registroVeiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@PathVariable Long veiculoId,
            @Valid @RequestBody AutuacaoInput autuacaoInput) {

        var autuacao = autuacaoAssembler.toEntity(autuacaoInput);
        var novaAutuacao = registroAutuacaoService.registrar(veiculoId, autuacao);
        return autuacaoAssembler.toModel(novaAutuacao);
    }

    @GetMapping
    public List<AutuacaoModel> listar(@PathVariable Long veiculoId) {
        var veiculo = registroVeiculoService.buscar(veiculoId);
        return autuacaoAssembler.toCollectionModel(veiculo.getAutuacoes());
    }

}
