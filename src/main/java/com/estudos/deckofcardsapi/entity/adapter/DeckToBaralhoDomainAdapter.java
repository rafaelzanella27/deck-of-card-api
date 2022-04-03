package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.enums.NipeType;

import java.util.*;

public class DeckToBaralhoDomainAdapter {

    public BaralhoDomain converte(Map<String, Object> entrada){
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
                Map<String, Object> pilhas = (Map<String, Object>) entrada.get("piles");
                baralhoDomain.setPilhas(this.convertePilhas(pilhas));
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

    private Map<String, Object> convertePilhas(Map<String, Object> pilhas){
        Map<String, Object> pilhasMap = new HashMap<>();
        if (Objects.nonNull(pilhas)){
            if (pilhas.containsKey("jogador1") && Objects.nonNull(pilhas.get("jogador1"))){
                Map<String, Object> jogadorMap = (Map<String, Object>) pilhas.get("jogador1");
                Map<String, Object> jogador1 = new HashMap<>();
                if (Objects.nonNull(jogadorMap) && jogadorMap.containsKey("remaining")){
                    jogador1.put("restante", jogadorMap.get("remaining"));
                }
                pilhasMap.put("jogador1", jogador1);
            }
        }
        return pilhasMap;
    }

    private String booleanToString(String valor){
        if (valor.equalsIgnoreCase("true")){
            return "sim";
        } return "não";
    }
}
