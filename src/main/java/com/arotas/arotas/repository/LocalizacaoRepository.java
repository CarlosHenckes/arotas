package com.arotas.arotas.repository;

import com.arotas.arotas.model.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends MongoRepository<Veiculo, String> {

}
