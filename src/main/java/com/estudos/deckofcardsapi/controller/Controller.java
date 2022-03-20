package com.estudos.deckofcardsapi.controller;

import com.estudos.deckofcardsapi.service.NovoBaralhoEmbaralhadoService;
import com.estudos.deckofcardsapi.service.NovoBaralhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    NovoBaralhoService novoBaralhoService;

    @Autowired
    NovoBaralhoEmbaralhadoService novoBaralhoEmbaralhadoService;

    @GetMapping("/novoBaralho/")
    public ResponseEntity novoBaralho(){
        Map<String, Object> dtoResponse = novoBaralhoService.execute();
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/novoBaralhoEmbaralhado/")
    public ResponseEntity novoBaralhoEmbaralhado(){
        Map<String, Object> dtoResponse = novoBaralhoEmbaralhadoService.execute();
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }
}
