package com.example.pruebatecnica.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.pruebatecnica.models.AsignacionId;
import com.example.pruebatecnica.models.AsignacionModel;

@Repository
public interface AsignacionRepository  extends CrudRepository<AsignacionModel, AsignacionId>{

    public abstract AsignacionModel findByIdEstudianteAndIdExamen(Long idEstudiante, Long idExamen);
    
}
