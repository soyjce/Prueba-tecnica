package com.example.pruebatecnica.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.pruebatecnica.models.OpcionModel;
import com.example.pruebatecnica.repositories.OpcionRepository;

@Service
public class OpcionService {

    @Autowired
    OpcionRepository OpcionRespository;


    public OpcionModel guardarOpcion(OpcionModel Opcion){

        return OpcionRespository.save(Opcion);

    }
    
}
