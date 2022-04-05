package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.entity.GeraResultadoEntity;
import com.estudos.deckofcardsapi.entity.OperacoesPilhaEntity;
import com.estudos.deckofcardsapi.feign.ResourceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GeraResultadosService {

    @Autowired
    ResourceFeignClient resourceFeignClient;

    public Map<String, Object> somarCartaPilha(String deck_id, String pile_name){
        Map<String, Object> retornoApiExterna = resourceFeignClient.listarPilha(deck_id, pile_name);
        OperacoesPilhaEntity operacoesPilhaEntity = OperacoesPilhaEntity.inicializa(retornoApiExterna, pile_name);
        return operacoesPilhaEntity.geraSomatoriaCartas();
    }

    public Map<String, Object> gerarResultado(String deck_id){
        Map<String, Object> retornoApiExterna = resourceFeignClient.listarPilha(deck_id, "jogador1");
        Map<String, Object> retornoApiExterna2 = resourceFeignClient.listarPilha(deck_id,"jogador2");
        Map<String, Object> retornoApiExterna3 = resourceFeignClient.listarPilha(deck_id,"jogador3");
        Map<String, Object> retornoApiExterna4 = resourceFeignClient.listarPilha(deck_id,"jogador4");

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("baralho_id", deck_id);
        resultado = GeraResultadoEntity.inicializa(retornoApiExterna, retornoApiExterna2, retornoApiExterna3, retornoApiExterna4).geraResultado();
        return resultado;
    }
}
