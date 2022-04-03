package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.ListarPilhaEntity;
import com.estudos.deckofcardsapi.feign.ResourceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ListarPilhaService {

    @Autowired
    ResourceFeignClient resourceFeignClient;

    public Map<String, Object> execute(String deck_id, String pile_name){
        Map<String, Object> retornoApiExterna = resourceFeignClient.listarPilha(deck_id, pile_name);
        ListarPilhaEntity listarPilhaEntity = ListarPilhaEntity.inicializa(retornoApiExterna, pile_name);
        return listarPilhaEntity.geraSaida();
    }
}
