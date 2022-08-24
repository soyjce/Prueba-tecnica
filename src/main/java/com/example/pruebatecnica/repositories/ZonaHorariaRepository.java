package com.example.pruebatecnica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebatecnica.models.ZonaHorariaModel;

@Repository
public interface ZonaHorariaRepository extends CrudRepository<ZonaHorariaModel, Long>{
  
    
}
