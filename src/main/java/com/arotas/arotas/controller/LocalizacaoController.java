package com.arotas.arotas.controller;

import com.arotas.arotas.model.Percorridas;
import com.arotas.arotas.model.Status;
import com.arotas.arotas.model.Veiculo;
import com.arotas.arotas.model.Viagem;
import com.arotas.arotas.service.LocalizacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RestController
@RequestMapping("/loc")
@Api(value="ARotas", description="ARotas - Serviços de controle de frotas autônoma")
public class LocalizacaoController {

    @Autowired
    LocalizacaoService service;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping @ApiOperation(value = "Lista de veículos cadastrados", response = List.class)
    public List<Veiculo> veiculos(){
        return  service.veiculos();
    }

    @GetMapping("/{placa}") @ApiOperation(value = "Dados do veículo por placa", response = Veiculo.class)
    public Veiculo buscarVeiculoPorPlaca(@PathVariable(value = "placa") String placa){
        return service.veiculoPorPlaca(placa.toUpperCase());
    }

    @GetMapping("/status/{status}") @ApiOperation(value = "Lista de veículos por status", response = List.class)
    public  List<Veiculo> veiculosPorStatus(@PathVariable(value = "status") Status status){
        return service.veiculosPorStatus(status);
    }

    @GetMapping("/near/{latitude}/{longitude}/{distance}")
    @ApiOperation(value = "Lista de veículos ao redor da localização fornecida", response = GeoResults.class)
    public GeoResults<Veiculo> buscarVeiculosProximos(@PathVariable(value = "latitude") float latitude,
                                                      @PathVariable(value = "longitude") float longitude,
                                                      @PathVariable(value = "distance") float distance){
        // example: loc/near/-23.574050/-46.623072/1.0
        return service.veiculosProximos(latitude, longitude, distance);
    }

    @PostMapping @ApiOperation(value = "Registrar um novo veículo.")
    public ResponseEntity adicionarVeiculo(@RequestBody Veiculo veiculo){
        service.adicionarVeiculo(veiculo);
        return new ResponseEntity("Novo veículo criado", HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar dados do veículos cadastrados")
    public void atualizarStatus(@RequestBody Veiculo veiculo){
        service.atualizarStatus(veiculo);
    }

    @PostMapping("/corrida") @ApiOperation(value = "Registrar uma nova corrida para o veículo")
    public void adicinarCorrida(@RequestBody Viagem viagem){
        service.registrarCorrida(viagem);
    }

    @GetMapping("/percorridas") @ApiOperation(value = "Sumário das corridas realizadas pela frota", response = List.class)
    public  List<Percorridas> resumoDasCorridas(){

        Aggregation aggregation = newAggregation(
                group("placa").sum("percorrida").as("kilometrosPercorridos")
                .addToSet("placa").as("placa"),
                sort(Sort.Direction.ASC, previousOperation(), "kilometrosPercorridos")
        );

        AggregationResults groupResults = mongoTemplate.aggregate(
                aggregation, Viagem.class, Percorridas.class);

        List percorridas = groupResults.getMappedResults();

        return percorridas;
    }
}
