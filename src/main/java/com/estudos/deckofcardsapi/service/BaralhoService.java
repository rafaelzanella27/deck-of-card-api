package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.BaralhoCriadoEntity;
import com.estudos.deckofcardsapi.entity.NovoBaralhoEntity;
import com.estudos.deckofcardsapi.feign.ResourceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BaralhoService {

    @Autowired
    ResourceFeignClient resourceFeignClient;

    public Map<String, Object> novoBaralhoOrdenado(){
        Map<String, Object> retornoApiExterna = resourceFeignClient.novoBaralhoOrdenado();
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }

    public Map<String, Object> novoBaralhoEmbaralhado(){
        Map<String, Object> retornoApiExterna = resourceFeignClient.novoBaralhoEmbaralhado();
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }

    public Map<String, Object> novoBaralhoParcialEmbaralhado(String cards){
        Map<String, Object> retornoApiExterna = resourceFeignClient.novoBaralhoParcialEmbaralhado(cards);
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }

    public Map<String, Object> reembaralharBaralho(String deck_id){
        Map<String, Object> retornoApiExterna = resourceFeignClient.reembaralhar(deck_id);
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }

    public Map<String, Object> tirarCarta(String deck_id, String count){
        Map<String, Object> retornoApiExterna = resourceFeignClient.tirarCarta(deck_id, count);
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }
}
