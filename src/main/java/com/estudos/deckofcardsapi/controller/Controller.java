package com.estudos.deckofcardsapi.controller;

import com.estudos.deckofcardsapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    TirarCartaService tirarCartaService;

    @Autowired
    ReembaralharCartasService reembaralharCartasService;

    @Autowired
    NovoBaralhoService novoBaralhoService;

    @Autowired
    AdicionarCartaNaPilhaService adicionarCartaNaPilhaService;

    @Autowired
    EmbaralharPilhaService embaralharPilhaService;

    @Autowired
    ListarPilhaService listarPilhaService;

    @Autowired
    TirarCartaPilhaService tirarCartaPilhaService;

    @Autowired
    SomarCartaPilhaService somarCartaPilhaService;

    @GetMapping("/novoBaralhoOrdenado/")
    public ResponseEntity novoBaralhoOrdenado(){
        Map<String, Object> dtoResponse = novoBaralhoService.novoBaralhoOrdenado();
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/novoBaralhoEmbaralhado/")
    public ResponseEntity novoBaralhoEmbaralhado(){
        Map<String, Object> dtoResponse = novoBaralhoService.novoBaralhoEmbaralhado();
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/novoBaralhoParcial/")
    public ResponseEntity novoBaralhoParcial(@RequestParam("cards") String cards){
        Map<String, Object> dtoResponse = novoBaralhoService.novoBaralhoParcialEmbaralhado(cards);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/reembaralhar/baralho/{deck_id}")
    public ResponseEntity reembaralhar(@PathVariable("deck_id") String deck_id){
        Map<String, Object> dtoResponse = reembaralharCartasService.execute(deck_id);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/tirarCarta/baralho/{deck_id}")
    public ResponseEntity tirarCarta(@PathVariable("deck_id") String deck_id, @RequestParam("count") String count){
        Map<String, Object> dtoResponse = tirarCartaService.execute(deck_id, count);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/baralho/{deck_id}/pilha/{pile_name}/adicionarCarta/")
    public ResponseEntity adicionarCartaNaPilha(@PathVariable("deck_id") String deck_id, @PathVariable("pile_name") String pile_name, @RequestParam("cards") String cards){
        Map<String, Object> dtoResponse = adicionarCartaNaPilhaService.execute(deck_id, pile_name, cards);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/baralho/{deck_id}/pilha/{pile_name}/embaralharPilha/")
    public ResponseEntity embaralharPilha(@PathVariable("deck_id") String deck_id, @PathVariable("pile_name") String pile_name){
        Map<String, Object> dtoResponse = embaralharPilhaService.execute(deck_id, pile_name);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/baralho/{deck_id}/pilha/{pile_name}/listarPilha/")
    public ResponseEntity listarPilha(@PathVariable("deck_id") String deck_id, @PathVariable("pile_name") String pile_name){
        Map<String, Object> dtoResponse = listarPilhaService.execute(deck_id, pile_name);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/baralho/{deck_id}/pilha/{pile_name}/tirarCartaPilha/")
    public ResponseEntity tirarCartaPilha(@PathVariable("deck_id") String deck_id, @PathVariable("pile_name") String pile_name, @RequestParam("count") String count){
        Map<String, Object> dtoResponse = tirarCartaPilhaService.execute(deck_id, pile_name, count);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/baralho/{deck_id}/pilha/{pile_name}/somar/")
    public ResponseEntity somarCartasJogador(@PathVariable("deck_id") String deck_id, @PathVariable("pile_name") String pile_name){
        Map<String, Object> dtoResponse = somarCartaPilhaService.somarCartaPilha(deck_id, pile_name);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

    @GetMapping("/baralho/{deck_id}/gerarResultado/")
    public ResponseEntity gerarResultado(@PathVariable("deck_id") String deck_id){
        Map<String, Object> dtoResponse = somarCartaPilhaService.gerarResultado(deck_id);
        return new ResponseEntity(dtoResponse, HttpStatus.OK);
    }

}
