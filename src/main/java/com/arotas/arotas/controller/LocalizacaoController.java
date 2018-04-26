package com.arotas.arotas.controller;

import com.arotas.arotas.model.Veiculo;
import com.arotas.arotas.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{placa}")
    public Veiculo buscarVeiculoPorPlaca(@PathVariable(value = "placa") String placa){
        return service.veiculoPorPlaca(placa.toUpperCase());
    }

    @GetMapping("/near/{latitude}/{longitude}/{distance}")
    public GeoResults<Veiculo> buscarVeiculosProximos(@PathVariable(value = "latitude") float latitude,
                                                      @PathVariable(value = "longitude") float longitude,
                                                      @PathVariable(value = "distance") float distance){
        // example: loc/near/-23.574050/-46.623072/1.0
        return service.veiculosProximos(latitude, longitude, distance);
    }
}
