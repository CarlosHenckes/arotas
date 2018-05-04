package com.arotas.arotas.service;

import com.arotas.arotas.model.Percorridas;
import com.arotas.arotas.model.Status;
import com.arotas.arotas.model.Veiculo;
import com.arotas.arotas.model.Viagem;
import com.arotas.arotas.repository.LocalizacaoRepository;
import com.arotas.arotas.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;


@Service
public class LocalizacaoService {

    @Autowired
    LocalizacaoRepository repository;

    @Autowired
    ViagemRepository viagemRepository;

    public List<Veiculo> veiculos(){
        return repository.findAll();
    }

    public Veiculo veiculoPorPlaca(String placa){
        return repository.findByPlaca(placa);
    }

    public GeoResults<Veiculo> veiculosProximos(float latitude, float longitude, float distance){
        return repository.findByLocalizacaoNearAndStatus(new Point(latitude, longitude),
                                    new Distance(distance, Metrics.KILOMETERS), Status.LIVRE);
    }

    public void adicionarVeiculo(Veiculo veiculo){
        repository.save(veiculo);
    }

    public void atualizarStatus(Veiculo veiculo){
        repository.save(veiculo);
    }

    public void registrarCorrida(Viagem viagem){
        viagemRepository.save(viagem);
    }

    public List<Veiculo> veiculosPorStatus(Status status){
        return repository.findByStatus(status);
    }

}
