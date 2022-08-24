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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.pruebatecnica.models.AsignacionModel;
import com.example.pruebatecnica.models.ExamenModel;
import com.example.pruebatecnica.models.OpcionModel;
import com.example.pruebatecnica.models.PreguntaModel;
import com.example.pruebatecnica.models.RespuestaModel;
import com.example.pruebatecnica.services.AsignacionService;
import com.example.pruebatecnica.services.ExamenService;
import com.example.pruebatecnica.services.RespuestaService;

@RestController
@RequestMapping("/asignacion")
public class AsignacionController {

    @Autowired
    AsignacionService asignacionService;

    @Autowired
    ExamenService examenService;

    @Autowired
    RespuestaService respuestaService;


    @PostMapping()
    public AsignacionModel guardarAsignacion(@RequestBody AsignacionModel asignacion){

        return this.asignacionService.guardarAsignacion(asignacion);
       
    }


    @GetMapping("/query")
    public AsignacionModel obtenerAsignacionCalificacion(@RequestParam("idEstudiante") Long idEstudiante, @RequestParam("idExamen") Long idExamen){

        
        AsignacionModel asignacion = this.asignacionService.obtenerPorIdEstudianteYIdExamen(idEstudiante, idExamen);
        Optional <ExamenModel> examen = this.examenService.obtenerPorId(idExamen);
        ArrayList<RespuestaModel> respuestasExamen = this.respuestaService.obtenerPorIdEstudianteYIdExamen(idEstudiante, idExamen);
        Integer calificacion = (Integer) 0;

        for (PreguntaModel _preguntaModel : examen.get().getPreguntas()) {

            System.out.println("Pregunta: " + _preguntaModel.getDescripcion() );

            RespuestaModel tempResMod = respuestasExamen.stream()
            .filter(idPregunta -> _preguntaModel.getIdPregunta().equals(idPregunta.getIdPregunta()))
            .findAny()
            .orElse(null);

            System.out.println("Estudiante: " + idEstudiante + "Examen: " + idExamen);

            OpcionModel opcionCorrecta = _preguntaModel.getOpciones().stream()        
            .filter(esCorrecta -> esCorrecta.getEsCorrecta().equals(true))
            .findAny()
            .orElse(null);


            System.out.println("Opcion Correcta ID:" + opcionCorrecta.getIdOpcion() + "opcion seleccionada: " + tempResMod.getIdOpcion());

            if(opcionCorrecta.getIdOpcion().equals(tempResMod.getIdOpcion())){

                calificacion += opcionCorrecta.getPuntos();
            }
            
        }
        
        asignacion.setCalificacion(calificacion);
        this.asignacionService.guardarAsignacion(asignacion);
        
        return asignacion;
    }


    @DeleteMapping( path = "/{id}" )
    public String eliminarPorId(@PathVariable("id") Long id){

        boolean flagOk = asignacionService.eliminarAsignacion(id);

        if(flagOk){

            return "Se eliminó el asignacion con id: " + id;
        }else{

            return "No se pudo eliminar el asignacion con id: " + id;
        }
    }

    
}
