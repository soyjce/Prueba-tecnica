package com.example.pruebatecnica.controllers;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pruebatecnica.models.EstudianteModel;
import com.example.pruebatecnica.services.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping()
    public ArrayList<EstudianteModel> obtenerEstudiantes(){

        return estudianteService.obtenerEstudiantes();

    }
    
    @PostMapping()
    public EstudianteModel guardarEstudiante(@RequestBody EstudianteModel estudiante){

        return this.estudianteService.guardarEstudiante(estudiante);
       
    }


    @GetMapping( path = "/{id}" )
    public Optional<EstudianteModel> obtenerEstudiantePorId(@PathVariable("id") Long id){

        return estudianteService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}" )
    public String eliminarPorId(@PathVariable("id") Long id){

        boolean flagOk = estudianteService.eliminarEstudiante(id);

        if(flagOk){

            return "Se eliminó el estdiante con id: " + id;
        }else{

            return "No se pudo eliminar el estudiante con id: " + id;
        }
    }

    
}
