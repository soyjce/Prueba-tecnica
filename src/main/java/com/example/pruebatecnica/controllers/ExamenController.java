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
import com.example.pruebatecnica.models.ExamenModel;
import com.example.pruebatecnica.models.OpcionModel;
import com.example.pruebatecnica.models.PreguntaModel;
import com.example.pruebatecnica.services.ExamenService;


@RestController
@RequestMapping("/examen")
public class ExamenController {

    @Autowired
    ExamenService examenService;

    @GetMapping()
    public ArrayList<ExamenModel> obtenerExamenes(){

        return examenService.obtenerExamenes();

    }
    
    @PostMapping()
    public ExamenModel guardarExamen(@RequestBody ExamenModel examen){

        ArrayList<PreguntaModel> listaPreguntas  = new ArrayList<PreguntaModel>();
        ArrayList<OpcionModel>listaOpciones =  new ArrayList<OpcionModel>();
        PreguntaModel preguntaModelo;
        OpcionModel opcionModelo;
        
        for (PreguntaModel _preguntaModel : examen.getPreguntas()) {
         
            preguntaModelo = new PreguntaModel();            
            preguntaModelo.setDescripcion(_preguntaModel.getDescripcion());
            preguntaModelo.setExamen(examen);       

            //System.out.println(preguntaModelo.getDescripcion());

            for (OpcionModel _opcionModel : _preguntaModel.getOpciones()) {
         
                
                opcionModelo = new OpcionModel();

                /*System.out.println(_opcionModel.getDescripcion() 
                + " ES CORRECTA: "  + _opcionModel.getEsCorrecta()
                + " "  + _opcionModel.getPuntos()
                + " " + _preguntaModel.getDescripcion());
*/

                opcionModelo.setDescripcion(_opcionModel.getDescripcion());
                opcionModelo.setEsCorrecta(_opcionModel.getEsCorrecta());
                opcionModelo.setPuntos(_opcionModel.getPuntos());
                opcionModelo.setPregunta(preguntaModelo);                
                listaOpciones.add(opcionModelo);


            }

            preguntaModelo.setOpciones(listaOpciones);
            listaPreguntas.add(preguntaModelo);
        }
                
        examen.setPreguntas(listaPreguntas);



        this.examenService.guardarExamen(examen);

        listaPreguntas = null;
        preguntaModelo = null;
        listaOpciones = null;
        opcionModelo = null;

        return examen;
    }


    @GetMapping( path = "/{id}" )
    public Optional<ExamenModel> obtenerExamenPorId(@PathVariable("id") Long id){

        return examenService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<ExamenModel> obtenerUsuarioPorDescripcion(@RequestParam("descripcion") String desripcion){

        return examenService.obtenerPorDescripcion(desripcion);
    }


    @DeleteMapping( path = "/{id}" )
    public String eliminarPorId(@PathVariable("id") Long id){

        boolean flagOk = examenService.eliminarExamen(id);

        if(flagOk){

            return "Se eliminó el usuario con id: " + id;
        }else{

            return "No se pudo eliminar el usuario con id: " + id;
        }
    }

    
}
