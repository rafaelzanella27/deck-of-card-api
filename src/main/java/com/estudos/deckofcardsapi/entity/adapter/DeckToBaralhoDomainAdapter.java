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
                baralhoDomain.setRestante(entrada.get("remaining").toString());
            }
            if (entrada.containsKey("cards")){
                List<Map<String, Object>> cardsList = (ArrayList<Map<String, Object>>) entrada.get("cards");
                List<Map<String, Object>> cartaDomainList = this.converteCartas(cardsList);
                baralhoDomain.setCartas(cartaDomainList);
            }
        }
        return baralhoDomain;
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

    private String booleanToString(String valor){
        if (valor.equalsIgnoreCase("true")){
            return "sim";
        } return "não";
    }
}
