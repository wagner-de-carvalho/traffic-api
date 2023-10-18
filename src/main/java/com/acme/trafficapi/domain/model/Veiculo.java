package com.acme.trafficapi.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.acme.trafficapi.domain.exception.NegocioException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private Proprietario proprietario;

    private String marca;

    private String modelo;

    private String placa;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<Autuacao> autuacoes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    private OffsetDateTime dataCadastro;

    private OffsetDateTime dataApreensao;

    public Autuacao adicionarAutuacao(Autuacao autuacao) {
        autuacao.setVeiculo(this);
        autuacao.setDataOcorrencia(OffsetDateTime.now());
        getAutuacoes().add(autuacao);

        return autuacao;
    }

    public void apreender() {
        if (estaApreendido()) {
            throw new NegocioException("Veículo já se encontra apreendido");
        }

        setStatus(StatusVeiculo.APREENDIDO);
        setDataApreensao(OffsetDateTime.now());
    }

    public void removerApreensao() {
        if (naoEstaApreendido()) {
            throw new NegocioException("Veículo não está apreendido");
        }

        setStatus(StatusVeiculo.REGULAR);
        setDataApreensao(null);
    }

    public boolean estaApreendido() {
        return StatusVeiculo.APREENDIDO.equals(getStatus());
    }

    public boolean naoEstaApreendido() {
        return !estaApreendido();
    }
}
