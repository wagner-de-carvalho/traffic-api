package com.acme.trafficapi.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acme.trafficapi.api.model.VeiculoModel;
import com.acme.trafficapi.domain.model.Veiculo;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Veiculo.class, VeiculoModel.class)
                .addMappings(mapper -> mapper.map(Veiculo::getPlaca, VeiculoModel::setNumeroPlaca));
        return modelMapper;
    }

}
