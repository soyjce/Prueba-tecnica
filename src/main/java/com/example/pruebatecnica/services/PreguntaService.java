package com.example.pruebatecnica.services;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.pruebatecnica.models.PreguntaModel;
import com.example.pruebatecnica.repositories.PreguntaRepository;



@Service
public class PreguntaService {

    @Autowired
    PreguntaRepository preguntaRespository;


    public PreguntaModel guardarPregunta(PreguntaModel pregunta){

        return preguntaRespository.save(pregunta);

    }
    
}
