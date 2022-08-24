package com.example.pruebatecnica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebatecnica.models.OpcionModel;

@Repository
public interface OpcionRepository extends CrudRepository<OpcionModel, Long>{

    
    
}
