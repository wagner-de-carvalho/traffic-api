package com.acme.trafficapi.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.trafficapi.domain.model.Autuacao;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroAutuacaoService {
    private final RegistroVeiculoService registroVeiculoService;

    @Transactional
    public Autuacao registrar(Long veiculoId, Autuacao autuacao) {
        var veiculo = registroVeiculoService.buscar(veiculoId);

        autuacao.setVeiculo(veiculo);
        autuacao.setDataOcorrencia(OffsetDateTime.now());

        return veiculo.adicionarAutuacao(autuacao);
    }

}
