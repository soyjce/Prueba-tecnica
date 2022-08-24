package com.example.pruebatecnica.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebatecnica.models.EstudianteModel;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteModel, Long>{

   
    
}
