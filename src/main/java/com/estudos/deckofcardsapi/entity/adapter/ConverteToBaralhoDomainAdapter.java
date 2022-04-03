package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.enums.NipeType;

import java.util.*;

public class ConverteToBaralhoDomainAdapter {

    public BaralhoDomain converte(Map<String, Object> entrada, String pilha){
        BaralhoDomain baralhoDomain = new BaralhoDomain();
        if (Objects.nonNull(entrada)){

            if (entrada.containsKey("deck_id") && Objects.nonNull(entrada.get("deck_id"))){
                baralhoDomain.setBaralho_id(entrada.get("deck_id").toString());
            }
            if (entrada.containsKey("success") && Objects.nonNull(entrada.get("success"))){
                baralhoDomain.setSucesso(booleanToString(entrada.get("success").toString()));
            }
            if (entrada.containsKey("shuffled") && Objects.nonNull(entrada.get("shuffled"))){
                baralhoDomain.setEmbaralhado(booleanToString(entrada.get("shuffled").toString()));
            }
            if (entrada.containsKey("remaining") && Objects.nonNull(entrada.get("remaining"))){
                baralhoDomain.setRestante(this.converteStringToInteger(Float.parseFloat(entrada.get("remaining").toString())));
            }
            if (entrada.containsKey("cards")){
                List<Map<String, Object>> cardsList = (ArrayList<Map<String, Object>>) entrada.get("cards");
                List<Map<String, Object>> cartaDomainList = this.converteCartas(cardsList);
                baralhoDomain.setCartas(cartaDomainList);
            }
            if (entrada.containsKey("piles")){
                Map<String, Object> pilhasApi = (Map<String, Object>) entrada.get("piles");
                baralhoDomain.setPilhas(this.listarPilha(pilhasApi, pilha));
            }
        }
        return baralhoDomain;
    }

    private Integer converteStringToInteger (float valor){
        Integer resultado = (int)valor;
        return resultado;
    }

    private List<Map<String, Object>> converteCartas(List<Map<String, Object>> cardsList){
        List<Map<String, Object>> cartaDomainList = new ArrayList<>();
        for (int i = 0; i < cardsList.size(); i++){
            Map<String, Object> card = cardsList.get(i);
            Map<String, Object> carta = new HashMap<>();
            carta.put("codigo", card.get("code"));
            carta.put("imagem", card.get("image"));
            carta.put("valor", card.get("value"));
            carta.put("nipe", NipeType.converteNipe(card.get("suit").toString()));
            cartaDomainList.add(carta);
        }
        return cartaDomainList;
    }

    private Map<String, Object> listarPilha(Map<String, Object> pilhas, String pilha){
        if (Objects.nonNull(pilha)){
            if (pilha.equalsIgnoreCase("jogador1")){
                return this.listarJogador1(pilhas);
            } else if (pilha.equalsIgnoreCase("jogador2")){
                return this.listarJogador2(pilhas);
            } else if (pilha.equalsIgnoreCase("jogador3")){
                return this.listarJogador3(pilhas);
            } else return this.listarJogador4(pilhas);
        } return null;
    }

    private Map<String, Object> listarJogador1 (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador1 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador1") && Objects.nonNull(pilhas.get("jogador1"))){
                Map<String, Object> jogador1Api = (Map<String, Object>) pilhas.get("jogador1");

                if (jogador1Api.containsKey("remaining") && Objects.nonNull(jogador1Api.get("remaining"))){
                    jogador1.put("restante", jogador1Api.get("remaining"));
                }
                if (jogador1Api.containsKey("cards") && Objects.nonNull(jogador1Api.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador1Api.get("cards");
                    jogador1.put("cartas", this.converteCartas(cardsListApi));
                }
                pilhasMap.put("jogador1", jogador1);
            }
        }return pilhasMap;
    }

    private Map<String, Object> listarJogador2 (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador2 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador2") && Objects.nonNull(pilhas.get("jogador2"))){
                Map<String, Object> jogador2Api = (Map<String, Object>) pilhas.get("jogador2");

                if (jogador2Api.containsKey("remaining") && Objects.nonNull(jogador2Api.get("remaining"))){
                    jogador2.put("restante", jogador2Api.get("remaining"));
                }
                if (jogador2Api.containsKey("cards") && Objects.nonNull(jogador2Api.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador2Api.get("cards");
                    jogador2.put("cartas", this.converteCartas(cardsListApi));
                }
                pilhasMap.put("jogador2", jogador2);
            }
        }return pilhasMap;
    }

    private Map<String, Object> listarJogador3 (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador3 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador3") && Objects.nonNull(pilhas.get("jogador3"))){
                Map<String, Object> jogadorApi = (Map<String, Object>) pilhas.get("jogador3");

                if (jogadorApi.containsKey("remaining") && Objects.nonNull(jogadorApi.get("remaining"))){
                    jogador3.put("restante", jogadorApi.get("remaining"));
                }
                if (jogadorApi.containsKey("cards") && Objects.nonNull(jogadorApi.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogadorApi.get("cards");
                    jogador3.put("cartas", this.converteCartas(cardsListApi));
                }
                pilhasMap.put("jogador3", jogador3);
            }
        }return pilhasMap;
    }

    private Map<String, Object> listarJogador4 (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador4 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador4") && Objects.nonNull(pilhas.get("jogador4"))){
                Map<String, Object> jogadorApi = (Map<String, Object>) pilhas.get("jogador4");

                if (jogadorApi.containsKey("remaining") && Objects.nonNull(jogadorApi.get("remaining"))){
                    jogador4.put("restante", jogadorApi.get("remaining"));
                }
                if (jogadorApi.containsKey("cards") && Objects.nonNull(jogadorApi.get("cards"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogadorApi.get("cards");
                    jogador4.put("cartas", this.converteCartas(cardsListApi));
                }
                pilhasMap.put("jogador4", jogador4);
            }
        }return pilhasMap;
    }

    private String booleanToString(String valor){
        if (valor.equalsIgnoreCase("true")){
            return "sim";
        } return "não";
    }
}
