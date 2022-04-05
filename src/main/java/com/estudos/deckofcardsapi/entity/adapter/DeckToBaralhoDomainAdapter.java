package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;

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
                baralhoDomain.setCartas(CardsToCartasAdapter.inicializa().converteCartas(cardsList));
            }
            if (entrada.containsKey("piles")){
                Map<String, Object> pilhasApi = (Map<String, Object>) entrada.get("piles");
                baralhoDomain.setPilhas(PilesToPilhasAdapter.inicializa().convertePilhas(pilhasApi));
            }
        }
        return baralhoDomain;
    }

    private Integer converteStringToInteger (float valor){
        Integer resultado = (int)valor;
        return resultado;
    }

    private String booleanToString(String valor){
        if (valor.equalsIgnoreCase("true")){
            return "sim";
        } return "não";
    }
}
