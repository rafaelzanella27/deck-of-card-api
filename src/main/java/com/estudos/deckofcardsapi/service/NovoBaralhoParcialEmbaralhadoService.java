package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.BaralhoCriadoEntity;
import com.estudos.deckofcardsapi.entity.NovoBaralhoEntity;
import com.estudos.deckofcardsapi.feign.ResourceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NovoBaralhoParcialEmbaralhadoService {

    @Autowired
    ResourceFeignClient resourceFeignClient;

    public Map<String, Object> execute(String cards){
        Map<String, Object> retornoApiExterna = resourceFeignClient.novoBaralhoParcialEmbaralhado(cards);
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }
}
