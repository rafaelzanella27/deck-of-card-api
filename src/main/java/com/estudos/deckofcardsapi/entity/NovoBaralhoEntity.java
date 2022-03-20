package com.estudos.deckofcardsapi.entity;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.entity.adapter.DeckToBaralhoDomainAdapter;

import java.util.Map;

public class NovoBaralhoEntity {

    private Map<String, Object> entrada;

    private NovoBaralhoEntity(Map<String, Object> entrada){
        this.entrada = entrada;
        this.geraSaida();
    }

    public static NovoBaralhoEntity inicializa(Map<String, Object> entrada){
        return new NovoBaralhoEntity(entrada);
    }

    public BaralhoDomain geraSaida(){
        BaralhoDomain baralhoDomain = new DeckToBaralhoDomainAdapter().converte(this.entrada);
        return baralhoDomain;
    }

    public Map<String, Object> getEntrada(){
        return this.entrada;
    }
}
