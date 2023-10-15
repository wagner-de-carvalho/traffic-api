package com.acme.trafficapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.trafficapi.domain.model.Proprietario;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
    List<Proprietario> findByNomeContaining(String nome);

    Optional<Proprietario> findByEmail(String email);
}
