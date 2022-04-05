package com.estudos.deckofcardsapi.entity.adapter.resultados;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;

import java.util.*;

public class SomaCartasPilhaToMapAdapter {

    private SomaCartasPilhaToMapAdapter(){

    }

    public static SomaCartasPilhaToMapAdapter inicializa(){
        return new SomaCartasPilhaToMapAdapter();
    }

    public Map<String, Object> execute(BaralhoDomain baralhoDomain, String nomePilha){
        Map<String, Object> baralhoMap = new HashMap<>();
        if (Objects.nonNull(baralhoDomain)){
            if (Objects.nonNull(baralhoDomain.getBaralho_id())){
                baralhoMap.put("baralho_id", baralhoDomain.getBaralho_id());
            }
            if (Objects.nonNull(baralhoDomain.getRestante())){
                baralhoMap.put("restante", baralhoDomain.getRestante());
            }
            if (Objects.nonNull(baralhoDomain.getPilhas())){
                Map<String, Object> pilhas = baralhoDomain.getPilhas();
                baralhoMap.put("pilhas", this.pilha(pilhas, nomePilha));
            }
        }
        return baralhoMap;
    }

    private Integer soma(List<Map<String, Object>> cardsList){
        List<Map<String, Object>> cartaDomainList = new ArrayList<>();
        Integer resultado = 0;
        for (int i = 0; i < cardsList.size(); i++){
            Map<String, Object> card = cardsList.get(i);
            Map<String, Object> carta = new HashMap<>();
            resultado = resultado + Integer.parseInt(card.get("valor").toString());

    }return resultado;
    }

    private Map<String, Object> pilha(Map<String, Object> pilhas, String nomePilha){
        if (Objects.nonNull(nomePilha)){
            if (nomePilha.equalsIgnoreCase("jogador1")){
                return this.jogador1(pilhas);
            } else if (nomePilha.equalsIgnoreCase("jogador2")){
                return this.jogador2(pilhas);
            } else if (nomePilha.equalsIgnoreCase("jogador3")){
                return this.jogador3(pilhas);
            } else return this.jogador4(pilhas);
        } return null;
    }

    private Map<String, Object> jogador1 (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador1 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador1") && Objects.nonNull(pilhas.get("jogador1"))){
                Map<String, Object> jogador1Api = (Map<String, Object>) pilhas.get("jogador1");

                if (jogador1Api.containsKey("restante") && Objects.nonNull(jogador1Api.get("restante"))){
                    jogador1.put("restante", jogador1Api.get("restante"));
                }
                if (jogador1Api.containsKey("cartas") && Objects.nonNull(jogador1Api.get("cartas"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador1Api.get("cartas");
                    jogador1.put("cartas", this.converteCartas(cardsListApi));
                    jogador1.put("Total de pontos", this.soma(cardsListApi));
                }
                pilhasMap.put("jogador1", jogador1);
            }
        }return pilhasMap;
    }

    private Map<String, Object> jogador2 (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador2 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador2") && Objects.nonNull(pilhas.get("jogador2"))){
                Map<String, Object> jogador2Api = (Map<String, Object>) pilhas.get("jogador2");

                if (jogador2Api.containsKey("restante") && Objects.nonNull(jogador2Api.get("restante"))){
                    jogador2.put("restante", jogador2Api.get("restante"));
                }
                if (jogador2Api.containsKey("cartas") && Objects.nonNull(jogador2Api.get("cartas"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogador2Api.get("cartas");
                    jogador2.put("cartas", this.converteCartas(cardsListApi));
                    jogador2.put("Total de pontos", this.soma(cardsListApi));
                }
                pilhasMap.put("jogador2", jogador2);
            }
        }return pilhasMap;
    }

    private Map<String, Object> jogador3 (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador3 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador3") && Objects.nonNull(pilhas.get("jogador3"))){
                Map<String, Object> jogadorApi = (Map<String, Object>) pilhas.get("jogador3");

                if (jogadorApi.containsKey("restante") && Objects.nonNull(jogadorApi.get("restante"))){
                    jogador3.put("restante", jogadorApi.get("restante"));
                }
                if (jogadorApi.containsKey("cartas") && Objects.nonNull(jogadorApi.get("cartas"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogadorApi.get("cartas");
                    jogador3.put("cartas", this.converteCartas(cardsListApi));
                    jogador3.put("Total de pontos", this.soma(cardsListApi));
                }
                pilhasMap.put("jogador3", jogador3);
            }
        }return pilhasMap;
    }

    private Map<String, Object> jogador4 (Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        Map<String, Object> jogador4 = new HashMap<>();

        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador4") && Objects.nonNull(pilhas.get("jogador4"))){
                Map<String, Object> jogadorApi = (Map<String, Object>) pilhas.get("jogador4");

                if (jogadorApi.containsKey("restante") && Objects.nonNull(jogadorApi.get("restante"))){
                    jogador4.put("restante", jogadorApi.get("restante"));
                }
                if (jogadorApi.containsKey("cartas") && Objects.nonNull(jogadorApi.get("cartas"))){
                    List<Map<String, Object>> cardsListApi = (List<Map<String, Object>>) jogadorApi.get("cartas");
                    jogador4.put("cartas", this.converteCartas(cardsListApi));
                    jogador4.put("Total de pontos", this.soma(cardsListApi));
                }
                pilhasMap.put("jogador4", jogador4);
            }
        }return pilhasMap;
    }

    private List<Map<String, Object>> converteCartas(List<Map<String, Object>> cardsList){
        List<Map<String, Object>> cartaDomainList = new ArrayList<>();
        for (int i = 0; i < cardsList.size(); i++){
            Map<String, Object> card = cardsList.get(i);
            Map<String, Object> carta = new HashMap<>();
            carta.put("codigo", card.get("codigo"));
            carta.put("imagem", card.get("imagem"));
            carta.put("valor", card.get("valor"));
            carta.put("nipe", card.get("nipe"));
            cartaDomainList.add(carta);
        }
        return cartaDomainList;
    }
}
