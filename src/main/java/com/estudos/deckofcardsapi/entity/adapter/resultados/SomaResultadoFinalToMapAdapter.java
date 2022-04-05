package com.estudos.deckofcardsapi.entity.adapter.resultados;

import com.estudos.deckofcardsapi.domain.JogadorDomain;
import com.estudos.deckofcardsapi.enums.ValorType;

import java.util.*;

public class SomaResultadoFinalToMapAdapter {

    private SomaResultadoFinalToMapAdapter(){

    }

    public static SomaResultadoFinalToMapAdapter inicializa(){
        return new SomaResultadoFinalToMapAdapter();
    }


    public Map<String, Object> geraResultado(Map<String, Object> retornoApiExterna, Map<String, Object> retornoApiExterna2, Map<String, Object> retornoApiExterna3, Map<String, Object> retornoApiExterna4){
        Map<String, Object> resultadoMap = new HashMap<>();
        Map<String, Object> resultadoDetalhadoMap = new HashMap<>();
        List<JogadorDomain> totais = new ArrayList<>();

        Map<String, Object> retornoApi = (Map<String, Object>) retornoApiExterna.get("piles");
            if (Objects.nonNull(retornoApi) && retornoApi.containsKey("jogador1")){
                Map<String, Object> jogador1 = this.jogador1((Map<String, Object>) retornoApi.get("jogador1"));
                resultadoDetalhadoMap.put("Jogador1 obteve:", jogador1.get("somatoria") + " pontos");
                totais.add(new JogadorDomain("jogador1",Integer.parseInt(jogador1.get("somatoria").toString())));
            }
        Map<String, Object> retornoApi2 = (Map<String, Object>) retornoApiExterna2.get("piles");
            if (Objects.nonNull(retornoApi2) && retornoApi2.containsKey("jogador2")){
                Map<String, Object> jogador2 = this.jogador2((Map<String, Object>) retornoApi2.get("jogador2"));
                resultadoDetalhadoMap.put("Jogador2 obteve:", jogador2.get("somatoria") + " pontos");
                totais.add(new JogadorDomain("jogador2",Integer.parseInt(jogador2.get("somatoria").toString())));
            }
        Map<String, Object> retornoApi3 = (Map<String, Object>) retornoApiExterna3.get("piles");
            if (Objects.nonNull(retornoApi3) && retornoApi3.containsKey("jogador3")){
                Map<String, Object> jogador3 = this.jogador3((Map<String, Object>) retornoApi3.get("jogador3"));
                resultadoDetalhadoMap.put("Jogador3 obteve:", jogador3.get("somatoria") + " pontos");
                totais.add(new JogadorDomain("jogador3",Integer.parseInt(jogador3.get("somatoria").toString())));
            }
        Map<String, Object> retornoApi4 = (Map<String, Object>) retornoApiExterna4.get("piles");
           if (Objects.nonNull(retornoApi4) && retornoApi4.containsKey("jogador4")){
               Map<String, Object> jogador4 = this.jogador4((Map<String, Object>) retornoApi4.get("jogador4"));
               resultadoDetalhadoMap.put("Jogador4 obteve:", jogador4.get("somatoria") + " pontos");
               totais.add(new JogadorDomain("jogador4",Integer.parseInt(jogador4.get("somatoria").toString())));
           }

           totais.sort(Comparator.comparingInt(JogadorDomain::getPontos));

           resultadoMap.put("Colocação do menor para o maior", totais);
           resultadoMap.put("Estatísticas do jogo", resultadoDetalhadoMap);

        return resultadoMap;
    }


    private Integer soma(List<Map<String, Object>> cardsList){
        Integer resultado = 0;
        for (int i = 0; i < cardsList.size(); i++){
            Map<String, Object> card = cardsList.get(i);
            resultado = resultado + Integer.parseInt(card.get("valor").toString());
    }return resultado;
    }


    private Map<String, Object> jogador1 (Map<String, Object> jogador1Externo){
        Map<String, Object> jogador1 = new HashMap<>();

        if (Objects.nonNull(jogador1Externo)){
            if (jogador1Externo.containsKey("cards") && Objects.nonNull(jogador1Externo.get("cards"))){
                List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador1Externo.get("cards");
                jogador1.put("somatoria", this.soma(this.converteCartas(cardsListApi)));
            }
        } return jogador1;
    }

    private Map<String, Object> jogador2 (Map<String, Object> jogador2Externo){
        Map<String, Object> jogador2 = new HashMap<>();

        if (Objects.nonNull(jogador2Externo)){
            if (jogador2Externo.containsKey("cards") && Objects.nonNull(jogador2Externo.get("cards"))){
                List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador2Externo.get("cards");
                jogador2.put("somatoria", this.soma(this.converteCartas(cardsListApi)));
            }
        } return jogador2;
    }

    private Map<String, Object> jogador3 (Map<String, Object> jogador3Externo){
        Map<String, Object> jogador3 = new HashMap<>();

        if (Objects.nonNull(jogador3Externo)){
            if (jogador3Externo.containsKey("cards") && Objects.nonNull(jogador3Externo.get("cards"))){
                List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador3Externo.get("cards");
                jogador3.put("somatoria", this.soma(this.converteCartas(cardsListApi)));
            }
        } return jogador3;
    }

    private Map<String, Object> jogador4 (Map<String, Object> jogador4Externo){
        Map<String, Object> jogador4 = new HashMap<>();

        if (Objects.nonNull(jogador4Externo)){
            if (jogador4Externo.containsKey("cards") && Objects.nonNull(jogador4Externo.get("cards"))){
                List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador4Externo.get("cards");
                jogador4.put("somatoria", this.soma(this.converteCartas(cardsListApi)));
            }
        } return jogador4;
    }

    private List<Map<String, Object>> converteCartas(List<Map<String, Object>> cardsList){
        List<Map<String, Object>> cartaDomainList = new ArrayList<>();
        for (int i = 0; i < cardsList.size(); i++){
            Map<String, Object> card = cardsList.get(i);
            Map<String, Object> carta = new HashMap<>();
            carta.put("valor", ValorType.converteValor(card.get("value").toString()));
            cartaDomainList.add(carta);
        }
        return cartaDomainList;
    }
}
