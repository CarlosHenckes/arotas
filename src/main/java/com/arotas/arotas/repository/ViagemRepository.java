package com.arotas.arotas.repository;

import com.arotas.arotas.model.Viagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository extends MongoRepository<Viagem, String> {
}
