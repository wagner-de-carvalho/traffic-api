package com.acme.trafficapi.domain.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.trafficapi.domain.exception.NegocioException;
import com.acme.trafficapi.domain.model.Proprietario;
import com.acme.trafficapi.domain.repository.ProprietarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {
    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioException("Já existe um proprietário cadastrado com este e-mail");
        }
        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Long proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }

}
