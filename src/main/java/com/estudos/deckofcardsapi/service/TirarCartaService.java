package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.BaralhoCriadoEntity;
import com.estudos.deckofcardsapi.entity.NovoBaralhoEntity;
import com.estudos.deckofcardsapi.feign.ResourceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TirarCartaService {

    @Autowired
    ResourceFeignClient resourceFeignClient;

    public Map<String, Object> execute(String deck_id, String count){
        Map<String, Object> retornoApiExterna = resourceFeignClient.tirarCarta(deck_id, count);
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }
}
