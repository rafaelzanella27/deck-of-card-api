package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.enums.ValorType;

import java.util.*;

public class SomaResultadoFinalToMapAdapter {

    private SomaResultadoFinalToMapAdapter(){

    }

    public static SomaResultadoFinalToMapAdapter inicializa(){
        return new SomaResultadoFinalToMapAdapter();
    }


    public Map<String, Object> geraResultado(Map<String, Object> retornoJogador1 ,Map<String, Object> retornoJogador2, Map<String, Object> retornoJogador3, Map<String, Object> retornoJogador4){
        Map<String, Object> resultadoMap = new HashMap<>();

        Map<String, Object> pilesMap = (Map<String, Object>) retornoJogador1.get("piles");
            if (Objects.nonNull(pilesMap) && pilesMap.containsKey("jogador1")){
                Map<String, Object> jogador1 = this.jogador1(pilesMap);
                resultadoMap.put("Jogador1:", jogador1.get("somatoria"));
            }
        Map<String, Object> pilesMap2 = (Map<String, Object>) retornoJogador2.get("piles");
            if (Objects.nonNull(pilesMap2) && pilesMap2.containsKey("jogador2")){
                Map<String, Object> jogador2 = this.jogador2(pilesMap2);
                resultadoMap.put("Jogador2:", jogador2.get("somatoria"));
            }
        Map<String, Object> pilesMap3 = (Map<String, Object>) retornoJogador3.get("piles");
            if (Objects.nonNull(pilesMap3) && pilesMap3.containsKey("jogador3")){
                Map<String, Object> jogador3 = this.jogador3(pilesMap3);
                resultadoMap.put("Jogador3:", jogador3.get("somatoria"));
            }
        Map<String, Object> pilesMap4 = (Map<String, Object>) retornoJogador4.get("piles");
           if (Objects.nonNull(pilesMap4) && pilesMap4.containsKey("jogador4")){
               Map<String, Object> jogador4 = this.jogador4(pilesMap4);
               resultadoMap.put("Jogador4:", jogador4.get("somatoria"));
           }
        return resultadoMap;
    }

    private Integer soma(List<Map<String, Object>> cardsList){
        Integer resultado = 0;
        for (int i = 0; i < cardsList.size(); i++){
            Map<String, Object> card = cardsList.get(i);
            resultado = resultado + Integer.parseInt(card.get("valor").toString());
    }return resultado;
    }


    private Map<String, Object> jogador1 (Map<String, Object> pilhas){
        Map<String, Object> jogador1 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador1") && Objects.nonNull(pilhas.get("jogador1"))){
                Map<String, Object> jogador1Api = (Map<String, Object>) pilhas.get("jogador1");

                if (jogador1Api.containsKey("cards") && Objects.nonNull(jogador1Api.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador1Api.get("cards");
                    jogador1.put("somatoria", this.soma(this.converteCartas(cardsListApi)));
                }
            }
        }return jogador1;
    }

    private Map<String, Object> jogador2 (Map<String, Object> pilhas){
        Map<String, Object> jogador2 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador2") && Objects.nonNull(pilhas.get("jogador2"))){
                Map<String, Object> jogador2Api = (Map<String, Object>) pilhas.get("jogador2");

                if (jogador2Api.containsKey("cards") && Objects.nonNull(jogador2Api.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador2Api.get("cards");
                    jogador2.put("somatoria", this.soma(this.converteCartas(cardsListApi)));
                }
            }
        }return jogador2;
    }

    private Map<String, Object> jogador3 (Map<String, Object> pilhas){
        Map<String, Object> jogador3 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador3") && Objects.nonNull(pilhas.get("jogador3"))){
                Map<String, Object> jogadorApi = (Map<String, Object>) pilhas.get("jogador3");

                if (jogadorApi.containsKey("cards") && Objects.nonNull(jogadorApi.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogadorApi.get("cards");

                    jogador3.put("somatoria", this.soma(this.converteCartas(cardsListApi)));
                }
            }
        }return jogador3;
    }

    private Map<String, Object> jogador4 (Map<String, Object> pilhas){
        Map<String, Object> jogador4 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador4") && Objects.nonNull(pilhas.get("jogador4"))){
                Map<String, Object> jogadorApi = (Map<String, Object>) pilhas.get("jogador4");

                if (jogadorApi.containsKey("cards") && Objects.nonNull(jogadorApi.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogadorApi.get("cards");
                    jogador4.put("somatoria", this.soma(this.converteCartas(cardsListApi)));
                }
            }
        }return jogador4;
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
