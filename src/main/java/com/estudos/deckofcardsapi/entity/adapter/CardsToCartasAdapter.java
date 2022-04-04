package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.enums.NipeType;
import com.estudos.deckofcardsapi.enums.ValorType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardsToCartasAdapter {

    private CardsToCartasAdapter(){
    }

    public static CardsToCartasAdapter inicializa(){
        return new CardsToCartasAdapter();
    }

    public List<Map<String, Object>> converteCartas(List<Map<String, Object>> cardsList){
        List<Map<String, Object>> cartaDomainList = new ArrayList<>();
        for (int i = 0; i < cardsList.size(); i++){
            Map<String, Object> card = cardsList.get(i);
            Map<String, Object> carta = new HashMap<>();
            carta.put("codigo", card.get("code"));
            carta.put("imagem", card.get("image"));
            carta.put("valor", ValorType.converteValor(card.get("value").toString()));
            carta.put("nipe", NipeType.converteNipe(card.get("suit").toString()));
            cartaDomainList.add(carta);
        }
        return cartaDomainList;
    }
}
