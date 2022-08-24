package com.example.pruebatecnica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebatecnica.models.PaisModel;

@Repository
public interface PaisRepository extends CrudRepository<PaisModel, Long>{

   
    
}
