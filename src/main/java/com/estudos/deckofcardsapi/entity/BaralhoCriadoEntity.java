package com.estudos.deckofcardsapi.entity;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.entity.adapter.BaralhoCriadoToMapAdapter;

import java.util.Map;

public class BaralhoCriadoEntity {

    BaralhoDomain baralhoDomain;

    private BaralhoCriadoEntity(BaralhoDomain baralhoDomain){
        this.baralhoDomain = baralhoDomain;
        this.geraSaida();
    }

    public static BaralhoCriadoEntity inicializa(BaralhoDomain baralhoDomain){
        return new BaralhoCriadoEntity(baralhoDomain);
    }

    public Map<String, Object> geraSaida(){
        return new BaralhoCriadoToMapAdapter().execute(this.baralhoDomain);
    }
}
