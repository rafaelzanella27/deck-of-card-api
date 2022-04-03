package com.estudos.deckofcardsapi.entity;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.entity.adapter.BaralhoCriadoToMapAdapter;

import java.util.Map;
import java.util.Objects;

public class BaralhoCriadoEntity {

    private BaralhoDomain baralhoDomain;

    private BaralhoCriadoEntity(BaralhoDomain baralhoDomain){
        this.baralhoDomain = baralhoDomain;
        this.geraSaida();
    }

    public static BaralhoCriadoEntity inicializa(BaralhoDomain baralhoDomain){
        return new BaralhoCriadoEntity(baralhoDomain);
    }

    public Map<String, Object> geraSaida(){
        if (Objects.nonNull(this.baralhoDomain)){
            Map<String, Object> saida = BaralhoCriadoToMapAdapter.inicializa().converte(this.baralhoDomain);
            return saida ;
        }
        return null;
    }

}
