package com.example.pruebatecnica.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pruebatecnica.models.RespuestaModel;
import com.example.pruebatecnica.services.RespuestaService;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    RespuestaService respuestaService;

    @PostMapping()
    public List<RespuestaModel> guardarRespuestas(@RequestBody List<RespuestaModel> respuestas){

        List<RespuestaModel> lista = new ArrayList<RespuestaModel>();

        for (RespuestaModel respuestaModel : respuestas) {
            
            this.respuestaService.guardarAsignacion(respuestaModel);
            lista.add(respuestaModel);
        }

        return lista;       
    } 
    
}
