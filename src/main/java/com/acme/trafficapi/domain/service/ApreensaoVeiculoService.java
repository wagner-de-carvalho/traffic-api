package com.acme.trafficapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApreensaoVeiculoService {
    private final RegistroVeiculoService registroVeiculoService;

    @Transactional
    public void apreender(Long veiculoId) {
        var veiculo = registroVeiculoService.buscar(veiculoId);
        veiculo.apreender();
    }

    @Transactional
    public void removerApreensao(Long veiculoId) {
        var veiculo = registroVeiculoService.buscar(veiculoId);
        veiculo.removerApreensao();
    }
}
