package com.acme.trafficapi.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.trafficapi.domain.model.Proprietario;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @GetMapping
    public List<Proprietario> listar() {
        var p1 = new Proprietario(1L, "Carles", "carles@mail.com", "333356478");
        var p2 = new Proprietario(2L, "Penelope", "penelope@mail.com", "227745691");
        return Arrays.asList(p1, p2);
    }
}
