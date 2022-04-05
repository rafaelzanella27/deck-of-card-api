package com.estudos.deckofcardsapi.entity.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PilesToPilhasAdapter {

    private PilesToPilhasAdapter(){}

    public static PilesToPilhasAdapter inicializa(){
        return new PilesToPilhasAdapter();
    }

    public Map<String, Object> convertePilhas(Map<String, Object> pilhas){
        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador1") || pilhas.containsKey("jogador2") || pilhas.containsKey("jogador3") || pilhas.containsKey("jogador4")){
                return this.converteJogador(pilhas);
            }
        } return null;
    }

    private Map<String, Object> converteJogador (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador1 = new HashMap<>();
        Map<String, Object> jogador2 = new HashMap<>();
        Map<String, Object> jogador3 = new HashMap<>();
        Map<String, Object> jogador4 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador1") && Objects.nonNull(pilhas.get("jogador1"))){
                Map<String, Object> jogador1Api = (Map<String, Object>) pilhas.get("jogador1");

                if (jogador1Api.containsKey("remaining") && Objects.nonNull(jogador1Api.get("remaining"))){
                    jogador1.put("restante", jogador1Api.get("remaining"));
                }
                if (jogador1Api.containsKey("cards") && Objects.nonNull(jogador1Api.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador1Api.get("cards");
                    jogador1.put("cartas", CardsToCartasAdapter.inicializa().converteCartas(cardsListApi));
                }
                pilhasMap.put("jogador1", jogador1);
            }
            if (pilhas.containsKey("jogador2") && Objects.nonNull(pilhas.get("jogador2"))){
                Map<String, Object> jogador2Api = (Map<String, Object>) pilhas.get("jogador2");

                if (jogador2Api.containsKey("remaining") && Objects.nonNull(jogador2Api.get("remaining"))){
                    jogador1.put("restante", jogador2Api.get("remaining"));
                }
                if (jogador2Api.containsKey("cards") && Objects.nonNull(jogador2Api.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador2Api.get("cards");
                    jogador1.put("cartas", CardsToCartasAdapter.inicializa().converteCartas(cardsListApi));
                }
                pilhasMap.put("jogador2", jogador2);
            }
            if (pilhas.containsKey("jogador3") && Objects.nonNull(pilhas.get("jogador3"))){
                Map<String, Object> jogador3Api = (Map<String, Object>) pilhas.get("jogador3");

                if (jogador3Api.containsKey("remaining") && Objects.nonNull(jogador3Api.get("remaining"))){
                    jogador1.put("restante", jogador3Api.get("remaining"));
                }
                if (jogador3Api.containsKey("cards") && Objects.nonNull(jogador3Api.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador3Api.get("cards");
                    jogador1.put("cartas", CardsToCartasAdapter.inicializa().converteCartas(cardsListApi));
                }
                pilhasMap.put("jogador3", jogador3);
            }
            if (pilhas.containsKey("jogador4") && Objects.nonNull(pilhas.get("jogador4"))){
                Map<String, Object> jogador4Api = (Map<String, Object>) pilhas.get("jogador4");

                if (jogador4Api.containsKey("remaining") && Objects.nonNull(jogador4Api.get("remaining"))){
                    jogador1.put("restante", jogador4Api.get("remaining"));
                }
                if (jogador4Api.containsKey("cards") && Objects.nonNull(jogador4Api.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador4Api.get("cards");
                    jogador1.put("cartas", CardsToCartasAdapter.inicializa().converteCartas(cardsListApi));
                }
                pilhasMap.put("jogador4", jogador4);
            }
        }return pilhasMap;
    }
}
