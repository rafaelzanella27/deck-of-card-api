package com.estudos.deckofcardsapi.controller;

import com.estudos.deckofcardsapi.service.BaralhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    BaralhoService baralhoService;

    @GetMapping("/novoBaralho/")
    public ResponseEntity novoBaralho(){
        Map<String, Object> dtoResponse = baralhoService.execute();
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }
}
