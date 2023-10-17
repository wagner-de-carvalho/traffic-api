package com.acme.trafficapi.api.model;

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
    private ProprietarioResumoModel proprietario;
    private StatusVeiculo status;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;

}
