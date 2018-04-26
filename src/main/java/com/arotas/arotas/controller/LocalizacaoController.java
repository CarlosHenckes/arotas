package com.arotas.arotas.controller;

import com.arotas.arotas.model.Veiculo;
import com.arotas.arotas.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loc")
public class LocalizacaoController {

    @Autowired
    LocalizacaoService service;

    @GetMapping
    public List<Veiculo> veiculos(){
        return  service.veiculos();
    }
}
