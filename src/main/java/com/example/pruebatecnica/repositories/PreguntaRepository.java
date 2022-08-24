package com.example.pruebatecnica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebatecnica.models.PreguntaModel;

@Repository
public interface PreguntaRepository extends CrudRepository<PreguntaModel, Long>{
    
    
}
