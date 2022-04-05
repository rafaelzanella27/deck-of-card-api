package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaralhoDomainToMapAdapter {

    private BaralhoDomainToMapAdapter(){

    }

    public static BaralhoDomainToMapAdapter inicializa(){
        return new BaralhoDomainToMapAdapter();
    }

    public Map<String, Object> converte(BaralhoDomain baralhoDomain){
        Map<String, Object> baralhoMap = new HashMap<>();
        if (Objects.nonNull(baralhoDomain)){
            if (Objects.nonNull(baralhoDomain.getBaralho_id())){
                baralhoMap.put("baralho_id", baralhoDomain.getBaralho_id());
            }
            if (Objects.nonNull(baralhoDomain.getSucesso())){
                baralhoMap.put("sucesso", baralhoDomain.getSucesso());
            }
            if (Objects.nonNull(baralhoDomain.getEmbaralhado())){
                baralhoMap.put("embaralhado", baralhoDomain.getEmbaralhado());
            }
            if (Objects.nonNull(baralhoDomain.getRestante())){
                baralhoMap.put("restante", baralhoDomain.getRestante());
            }
            if (Objects.nonNull(baralhoDomain.getCartas())){
                baralhoMap.put("cartas", baralhoDomain.getCartas());
            }
            if (Objects.nonNull(baralhoDomain.getPilhas())){
                baralhoMap.put("pilhas", baralhoDomain.getPilhas());
            }
        }
        return baralhoMap;
    }
}
