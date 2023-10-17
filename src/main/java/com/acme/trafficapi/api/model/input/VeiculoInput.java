package com.acme.trafficapi.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoInput {
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]{3}[0-9][0-9a-zA-Z][0-9]{2}")
    private String placa;

    @NotBlank
    @Size(max = 20)

    private String marca;
    @NotBlank
    @Size(max = 20)
    private String modelo;

    @Valid
    @NotNull
    private ProprietarioIdInput proprietario;
}
