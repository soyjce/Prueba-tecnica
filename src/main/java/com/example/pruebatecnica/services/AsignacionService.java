package com.example.pruebatecnica.services;
import org.springframework.stereotype.Service;
import com.example.pruebatecnica.models.AsignacionModel;
import com.example.pruebatecnica.repositories.AsignacionRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AsignacionService {

    @Autowired
    AsignacionRepository asignacionRespository;


    public ArrayList<AsignacionModel> obtenerAsignacions(){

        return (ArrayList<AsignacionModel>)asignacionRespository.findAll();
    }

    public AsignacionModel guardarAsignacion(AsignacionModel asignacion){

        return asignacionRespository.save(asignacion);

    }

    public AsignacionModel  obtenerPorIdEstudianteYIdExamen(Long idEstudiante, long idExamen){

        return asignacionRespository.findByIdEstudianteAndIdExamen(idEstudiante, idExamen);
    }



    public boolean eliminarAsignacion(Long id){

        try{
            //asignacionRespository.deleteById(id);
            return true;        
        }catch(Exception err){
            return false;
        }
    }
    
}
