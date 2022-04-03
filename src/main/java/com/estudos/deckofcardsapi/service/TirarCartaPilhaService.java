package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.OperacoesPilhaEntity;
import com.estudos.deckofcardsapi.feign.ResourceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TirarCartaPilhaService {

    @Autowired
    ResourceFeignClient resourceFeignClient;

    public Map<String, Object> execute(String deck_id, String pile_name, String count){
        Map<String, Object> retornoApiExterna = resourceFeignClient.tirarCartaPilha(deck_id, pile_name, count);
        OperacoesPilhaEntity operacoesPilhaEntity = OperacoesPilhaEntity.inicializa(retornoApiExterna, pile_name);
        return operacoesPilhaEntity.geraSaida();
    }
}
