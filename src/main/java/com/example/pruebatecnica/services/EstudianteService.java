package com.example.pruebatecnica.services;
import org.springframework.stereotype.Service;
import com.example.pruebatecnica.models.EstudianteModel;
import com.example.pruebatecnica.repositories.EstudianteRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRespository;


    public ArrayList<EstudianteModel> obtenerEstudiantes(){

        return (ArrayList<EstudianteModel>)estudianteRespository.findAll();
    }

    public EstudianteModel guardarEstudiante(EstudianteModel estudiante){

        return estudianteRespository.save(estudiante);

    }

    public Optional<EstudianteModel>  obtenerPorId(Long idEstudiante){

        return estudianteRespository.findById(idEstudiante);
    }


    public boolean eliminarEstudiante(Long id){

        try{
            estudianteRespository.deleteById(id);
            return true;        
        }catch(Exception err){
            return false;
        }
    }
    
}
