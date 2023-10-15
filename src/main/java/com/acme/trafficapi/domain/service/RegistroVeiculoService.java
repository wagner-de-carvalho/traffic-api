package com.acme.trafficapi.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.trafficapi.domain.model.StatusVeiculo;
import com.acme.trafficapi.domain.model.Veiculo;
import com.acme.trafficapi.domain.repository.VeiculoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {
    private final VeiculoRepository veiculoRepository;

    @Transactional
    public Veiculo cadastrar(Veiculo veiculo) {
        veiculo.setStatus(StatusVeiculo.REGULAR);
        veiculo.setDataCadastro(LocalDateTime.now());

        return veiculoRepository.save(veiculo);
    }

    @Transactional
    public void excluir(Long veiculoId) {
        veiculoRepository.deleteById(veiculoId);
    }

}
