package com.acme.trafficapi.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.trafficapi.domain.exception.NegocioException;
import com.acme.trafficapi.domain.model.StatusVeiculo;
import com.acme.trafficapi.domain.model.Veiculo;
import com.acme.trafficapi.domain.repository.VeiculoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {
    private final RegistroProprietarioService registroProprietarioService;
    private final VeiculoRepository veiculoRepository;

    @Transactional
    public Veiculo cadastrar(Veiculo veiculo) {
        if (veiculo.getId() != null) {
            throw new NegocioException("Veículo a ser cadastrado não deve possuir um ID");
        }
        boolean placaEmUso = veiculoRepository.findByPlaca(veiculo.getPlaca())
                .filter(v -> !v.equals(veiculo))
                .isPresent();

        if (placaEmUso) {
            throw new NegocioException("Já existe um veículo cadastrado com esta placa");
        }

        var proprietario = registroProprietarioService.buscar(veiculo.getProprietario().getId());

        veiculo.setProprietario(proprietario);
        veiculo.setStatus(StatusVeiculo.REGULAR);
        veiculo.setDataCadastro(LocalDateTime.now());

        return veiculoRepository.save(veiculo);
    }

    @Transactional
    public void excluir(Long veiculoId) {
        veiculoRepository.deleteById(veiculoId);
    }

}
