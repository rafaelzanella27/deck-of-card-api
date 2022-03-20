package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.BaralhoCriadoEntity;
import com.estudos.deckofcardsapi.entity.NovoBaralhoEntity;
import com.estudos.deckofcardsapi.feign.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BaralhoService {

    @Autowired
    FeignClient feignClient;

    public Map<String, Object> execute(){
        Map<String, Object> retornoApiExterna = feignClient.novoBaralho();
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }
}
