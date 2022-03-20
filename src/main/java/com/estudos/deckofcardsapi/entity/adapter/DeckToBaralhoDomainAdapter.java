package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;

import java.util.Map;
import java.util.Objects;

public class DeckToBaralhoDomainAdapter {

    public BaralhoDomain converte(Map<String, Object> entrada){
        BaralhoDomain baralhoDomain = new BaralhoDomain();
        if (Objects.nonNull(entrada)){
            baralhoDomain.setBaralho_id(entrada.get("deck_id").toString());
            baralhoDomain.setSucesso(Boolean.valueOf((Boolean) entrada.get("success")));
            baralhoDomain.setEmbaralhado(Boolean.valueOf((Boolean) entrada.get("shuffled")));
            baralhoDomain.setRestante(entrada.get("remaining").toString());
        }
        return baralhoDomain;
    }
}
