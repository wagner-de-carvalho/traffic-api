package com.acme.trafficapi.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.acme.trafficapi.api.model.AutuacaoModel;
import com.acme.trafficapi.api.model.VeiculoModel;
import com.acme.trafficapi.api.model.input.AutuacaoInput;
import com.acme.trafficapi.api.model.input.VeiculoInput;
import com.acme.trafficapi.domain.model.Autuacao;
import com.acme.trafficapi.domain.model.Veiculo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AutuacaoAssembler {
    private final ModelMapper modelMapper;

    public Autuacao toEntity(AutuacaoInput autuacaoInput) {
        return modelMapper.map(autuacaoInput, Autuacao.class);
    }

    public AutuacaoModel toModel(Autuacao autuacao) {
        return modelMapper.map(autuacao, AutuacaoModel.class);
    }

    public List<AutuacaoModel> toCollectionModel(List<Autuacao> autuacoes) {
        return autuacoes.stream()
                .map(this::toModel)
                .toList();
    }

}
