package com.arotas.arotas.repository;

import com.arotas.arotas.model.Status;
import com.arotas.arotas.model.Veiculo;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LocalizacaoRepository extends MongoRepository<Veiculo, String> {
    Veiculo findByPlaca(String placa);
    GeoResults<Veiculo> findByLocalizacaoNearAndStatus(Point localizacao, Distance distance, Status status);
    List<Veiculo> findByStatus(Status status);
}
