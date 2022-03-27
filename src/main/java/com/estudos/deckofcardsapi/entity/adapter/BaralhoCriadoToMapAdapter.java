package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.domain.CartaDomain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BaralhoCriadoToMapAdapter {


    public Map<String, Object> execute(BaralhoDomain baralhoDomain){
        Map<String, Object> objectMap = new HashMap<>();
        List<CartaDomain> cartaDomains = baralhoDomain.getCartaDomains();
        if (Objects.nonNull(baralhoDomain.getSucesso())){
            objectMap.put("sucesso", booleanToString(baralhoDomain.getSucesso()));
        }
        if (Objects.nonNull(baralhoDomain.getEmbaralhado())){
            objectMap.put("embaralhado", booleanToString(baralhoDomain.getEmbaralhado()));
        }
        if (Objects.nonNull(baralhoDomain.getBaralho_id())){
            objectMap.put("baralho_id", baralhoDomain.getBaralho_id());
        }
        if (Objects.nonNull(baralhoDomain.getRestante())){
            objectMap.put("restante", baralhoDomain.getRestante());
        }
        if (Objects.nonNull(baralhoDomain.getCartaDomains())){
            objectMap.put("cartas", cartaDomains);
        }
        return objectMap;
    }

    private String booleanToString(Boolean valor){
        if (valor){
            return "sim";
        } return "não";
    }
}
