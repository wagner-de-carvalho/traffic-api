package com.acme.trafficapi.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.trafficapi.domain.model.Proprietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public List<Proprietario> listar() {
        return manager
                .createQuery("from Proprietario", Proprietario.class)
                .getResultList();
    }
}
