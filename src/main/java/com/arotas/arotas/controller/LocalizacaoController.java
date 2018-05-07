package com.arotas.arotas.controller;

import com.arotas.arotas.model.Percorridas;
import com.arotas.arotas.model.Status;
import com.arotas.arotas.model.Veiculo;
import com.arotas.arotas.model.Viagem;
import com.arotas.arotas.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RestController
@RequestMapping("/loc")
public class LocalizacaoController {

    @Autowired
    LocalizacaoService service;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping
    public List<Veiculo> veiculos(){
        return  service.veiculos();
    }

    @GetMapping("/{placa}")
    public Veiculo buscarVeiculoPorPlaca(@PathVariable(value = "placa") String placa){
        return service.veiculoPorPlaca(placa.toUpperCase());
    }

    @GetMapping("/status/{status}")
    public  List<Veiculo> veiculosPorStatus(@PathVariable(value = "status") Status status){
        return service.veiculosPorStatus(status);
    }

    @GetMapping("/near/{latitude}/{longitude}/{distance}")
    public GeoResults<Veiculo> buscarVeiculosProximos(@PathVariable(value = "latitude") float latitude,
                                                      @PathVariable(value = "longitude") float longitude,
                                                      @PathVariable(value = "distance") float distance){
        // example: loc/near/-23.574050/-46.623072/1.0
        return service.veiculosProximos(latitude, longitude, distance);
    }

    @PostMapping
    public void adicionarVeiculo(@RequestBody Veiculo veiculo){
        service.adicionarVeiculo(veiculo);
    }

    @PutMapping
    public void atualizarStatus(@RequestBody Veiculo veiculo){
        service.atualizarStatus(veiculo);
    }

    @PostMapping("/corrida")
    public void adicinarCorrida(@RequestBody Viagem viagem){
        service.registrarCorrida(viagem);
    }

    @GetMapping("/percorridas")
    public  List<Percorridas> resumoDasCorridas(){

        Aggregation aggregation = newAggregation(
                group("placa").sum("percorrida").as("kilometrosPercorridos"),
                sort(Sort.Direction.ASC, previousOperation(), "placa")
        );

        AggregationResults groupResults = mongoTemplate.aggregate(
                aggregation, Viagem.class, Percorridas.class);

        List percorridas = groupResults.getMappedResults();

        return percorridas;
    }

}
