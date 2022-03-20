package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;

import java.util.HashMap;
import java.util.Map;

public class BaralhoCriadoToMapAdapter {


    public Map<String, Object> execute(BaralhoDomain baralhoDomain){
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("sucesso", booleanToString(baralhoDomain.getSucesso()));
        objectMap.put("embaralhado", booleanToString(baralhoDomain.getEmbaralhado()));
        objectMap.put("baralho_id", baralhoDomain.getBaralho_id());
        objectMap.put("restante", baralhoDomain.getRestante());
        return objectMap;
    }

    private String booleanToString(Boolean valor){
        if (valor){
            return "sim";
        } return "não";
    }
}
