package com.example.pruebatecnica.services;
import org.springframework.stereotype.Service;
import com.example.pruebatecnica.models.RespuestaModel;
import com.example.pruebatecnica.repositories.RespuestaRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RespuestaService {

    @Autowired
    RespuestaRepository respuestaRespository;


    public ArrayList<RespuestaModel> obtenerRespuestas(){

        return (ArrayList<RespuestaModel>)respuestaRespository.findAll();
    }

    public RespuestaModel guardarAsignacion(RespuestaModel respuesta){

        return respuestaRespository.save(respuesta);

    }
    
    public ArrayList<RespuestaModel>  obtenerPorIdEstudianteYIdExamen(Long idEstudiante, Long idExamen){

        return (ArrayList<RespuestaModel> )this.respuestaRespository.findByIdEstudianteAndIdExamen(idEstudiante, idExamen);
    }
     
    
}
