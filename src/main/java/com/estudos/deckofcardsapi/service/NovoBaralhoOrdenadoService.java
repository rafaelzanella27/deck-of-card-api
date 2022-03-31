package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.NovoBaralhoEntity;
import com.estudos.deckofcardsapi.feign.ResourceFeignClient;
import com.estudos.deckofcardsapi.utils.ExtensaoJasonApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NovoBaralhoOrdenadoService {

    @Autowired
    ResourceFeignClient resourceFeignClient;

    @Autowired
    ExtensaoJasonApp extensaoJasonApp;

    public Map<String, Object> execute(){
        Map<String, Object> retornoApiExterna = resourceFeignClient.novoBaralhoOrdenado();
        String objetoJson = this.extensaoJasonApp.transformaObjetoEmStringJson(NovoBaralhoEntity.inicializa(retornoApiExterna).geraSaida());
        return this.extensaoJasonApp.transforma(objetoJson);
    }
}