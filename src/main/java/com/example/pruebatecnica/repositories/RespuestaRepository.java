package com.example.pruebatecnica.repositories;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.pruebatecnica.models.RespuestaModel;

@Repository
public interface RespuestaRepository  extends CrudRepository<RespuestaModel, Long>{

    public abstract ArrayList<RespuestaModel> findByIdEstudianteAndIdExamen(Long idEstudiante, Long idExamen);
    
}
