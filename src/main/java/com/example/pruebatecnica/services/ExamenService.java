package com.example.pruebatecnica.services;
import org.springframework.stereotype.Service;
import com.example.pruebatecnica.models.ExamenModel;
import com.example.pruebatecnica.repositories.ExamenRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ExamenService {

    @Autowired
    ExamenRepository examenRespository;


    public ArrayList<ExamenModel> obtenerExamenes(){

        return (ArrayList<ExamenModel>)examenRespository.findAll();
    }

    public ExamenModel guardarExamen(ExamenModel examen){

        return examenRespository.save(examen);

    }

    public Optional<ExamenModel> obtenerPorId(Long idExamen){

        return examenRespository.findById(idExamen);
    }


    
    public ArrayList<ExamenModel>  obtenerPorDescripcion(String descripcion){

        return (ArrayList<ExamenModel> )examenRespository.findByDescripcion(descripcion);
    }
    

    public boolean eliminarExamen(Long id){

        try{
            examenRespository.deleteById(id);
            return true;        
        }catch(Exception err){
            return false;
        }
    }
    
}
