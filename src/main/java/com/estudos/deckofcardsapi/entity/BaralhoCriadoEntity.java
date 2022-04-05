package com.estudos.deckofcardsapi.entity;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.entity.adapter.BaralhoDomainToMapAdapter;

import java.util.Map;
import java.util.Objects;

public class BaralhoCriadoEntity {

    private BaralhoDomain entrada;

    private BaralhoCriadoEntity(BaralhoDomain entrada){
        this.entrada = entrada;
    }

    public static BaralhoCriadoEntity inicializa(BaralhoDomain entrada){
        return new BaralhoCriadoEntity(entrada);
    }

    public Map<String, Object> geraSaida(){
        if (Objects.nonNull(this.entrada)){
            Map<String, Object> saida = BaralhoDomainToMapAdapter.inicializa().converte(this.entrada);
            return saida ;
        }
        return null;
    }

}
