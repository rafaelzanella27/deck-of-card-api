package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.domain.CartaDomain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DeckToBaralhoDomainAdapter {

    public BaralhoDomain converte(Map<String, Object> entrada){
        BaralhoDomain baralhoDomain = new BaralhoDomain();
        if (Objects.nonNull(entrada)){

            if (entrada.containsKey("deck_id") && Objects.nonNull(entrada.get("deck_id"))){
                baralhoDomain.setBaralho_id(entrada.get("deck_id").toString());
            }
            if (entrada.containsKey("success") && Objects.nonNull(entrada.get("success"))){
                baralhoDomain.setSucesso(Boolean.valueOf((Boolean) entrada.get("success")));
            }
            if (entrada.containsKey("shuffled") && Objects.nonNull(entrada.get("shuffled"))){
                baralhoDomain.setEmbaralhado(Boolean.valueOf((Boolean) entrada.get("shuffled")));
            }
            if (entrada.containsKey("remaining") && Objects.nonNull(entrada.get("remaining"))){
                baralhoDomain.setRestante(entrada.get("remaining").toString());
            }
            if (entrada.containsKey("cards")){
                List<CartaDomain> cartaDomains = (List<CartaDomain>) entrada.get("cards");
                baralhoDomain.setCartaDomains(cartaDomains);
            }
        }
        return baralhoDomain;
    }
}
