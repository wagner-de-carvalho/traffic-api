package com.acme.trafficapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.trafficapi.domain.model.Proprietario;
import java.util.List;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
    List<Proprietario> findByNomeContaining(String nome);
}
