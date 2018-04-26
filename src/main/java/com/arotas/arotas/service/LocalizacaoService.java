package com.arotas.arotas.service;

import com.arotas.arotas.model.Localizacao;
import com.arotas.arotas.model.Veiculo;
import com.arotas.arotas.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalizacaoService {

    @Autowired
    LocalizacaoRepository repository;

    public List<Veiculo> veiculos(){
        return repository.findAll();
    }

    public Veiculo veiculoPorPlaca(String placa){
        return repository.findByPlaca(placa);
    }

    public GeoResults<Veiculo> veiculosProximos(float latitude, float longitude, float distance){
        return repository.findOneLocalizacaoNear(new Point(latitude, longitude), new Distance(distance, Metrics.KILOMETERS));
    }
}
