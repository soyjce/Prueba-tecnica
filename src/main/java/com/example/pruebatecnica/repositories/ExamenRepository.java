package com.example.pruebatecnica.repositories;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebatecnica.models.ExamenModel;

@Repository
public interface ExamenRepository extends CrudRepository<ExamenModel, Long>{


    public abstract ArrayList<ExamenModel> findByDescripcion(String descripcion);
    
    
}
