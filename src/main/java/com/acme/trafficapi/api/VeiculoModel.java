package com.acme.trafficapi.api;

import java.time.OffsetDateTime;

import com.acme.trafficapi.domain.model.StatusVeiculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoModel {
    private Long id;
    private String numeroPlaca;
    private String modelo;
    private String nomeProprietario;
    private StatusVeiculo status;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;

}
