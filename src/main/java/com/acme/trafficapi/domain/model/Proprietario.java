package com.acme.trafficapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Proprietario {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
