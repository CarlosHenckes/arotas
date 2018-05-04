package com.arotas.arotas.repository;

import com.arotas.arotas.model.Viagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViagemRepository extends MongoRepository<Viagem, String> {

}
