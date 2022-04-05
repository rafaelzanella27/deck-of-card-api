package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.BaralhoCriadoEntity;
import com.estudos.deckofcardsapi.entity.NovoBaralhoEntity;
import com.estudos.deckofcardsapi.entity.OperacoesPilhaEntity;
import com.estudos.deckofcardsapi.feign.ResourceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PilhaService {

    @Autowired
    ResourceFeignClient resourceFeignClient;

    public Map<String, Object> adicionarCartaPilha(String deck_id, String pile_name, String cards){
        Map<String, Object> retornoApiExterna = resourceFeignClient.adicionarCartasPilha(deck_id, pile_name, cards);
        OperacoesPilhaEntity operacoesPilhaEntity = OperacoesPilhaEntity.inicializa(retornoApiExterna, pile_name);
        return operacoesPilhaEntity.geraSaida();
    }

    public Map<String, Object> embaralharPilha(String deck_id, String pile_name){
        Map<String, Object> retornoApiExterna = resourceFeignClient.embaralharPilha(deck_id, pile_name);
        NovoBaralhoEntity novoBaralhoEntity = NovoBaralhoEntity.inicializa(retornoApiExterna);
        BaralhoCriadoEntity baralhoCriadoEntity = BaralhoCriadoEntity.inicializa(novoBaralhoEntity.geraSaida());
        return baralhoCriadoEntity.geraSaida();
    }

    public Map<String, Object> listarPilha(String deck_id, String pile_name){
        Map<String, Object> retornoApiExterna = resourceFeignClient.listarPilha(deck_id, pile_name);
        OperacoesPilhaEntity operacoesPilhaEntity = OperacoesPilhaEntity.inicializa(retornoApiExterna, pile_name);
        return operacoesPilhaEntity.geraSaida();
    }

    public Map<String, Object> tirarCartaPilha(String deck_id, String pile_name, String count){
        Map<String, Object> retornoApiExterna = resourceFeignClient.tirarCartaPilha(deck_id, pile_name, count);
        OperacoesPilhaEntity operacoesPilhaEntity = OperacoesPilhaEntity.inicializa(retornoApiExterna, pile_name);
        return operacoesPilhaEntity.geraSaida();
    }
}
