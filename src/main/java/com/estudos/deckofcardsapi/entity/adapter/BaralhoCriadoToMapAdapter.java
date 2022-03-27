package com.estudos.deckofcardsapi.entity.adapter;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.domain.CartaDomain;
import com.estudos.deckofcardsapi.enums.NipeType;

import java.util.*;

public class BaralhoCriadoToMapAdapter {


    public Map<String, Object> execute(BaralhoDomain baralhoDomain){
        Map<String, Object> objectMapSaida = new HashMap<>();

        if (Objects.nonNull(baralhoDomain.getSucesso())){
            objectMapSaida.put("sucesso", booleanToString(baralhoDomain.getSucesso()));
        }
        if (Objects.nonNull(baralhoDomain.getBaralho_id())){
            objectMapSaida.put("baralho_id", baralhoDomain.getBaralho_id());
        }
        if (Objects.nonNull(baralhoDomain.getEmbaralhado())){
            objectMapSaida.put("embaralhado", booleanToString(baralhoDomain.getEmbaralhado()));
        }

        List<CartaDomain> cartaDomains = baralhoDomain.getCartaDomains();

        Map<String, Object> cardsMap = (Map<String, Object>) cartaDomains.get(0);

        Map<String, Object> cartaMap = new HashMap<>();

        cartaMap.put("codigo",cardsMap.get("code").toString());
        cartaMap.put("imagem",cardsMap.get("image"));
        cartaMap.put("valor",cardsMap.get("value"));
        cartaMap.put("nipe", NipeType.converteNipe(cardsMap.get("suit").toString()));

        List<Map<String, Object>> cartaDomainList = new ArrayList<>();
        cartaDomainList.add(0,cartaMap);

        if (Objects.nonNull(baralhoDomain.getCartaDomains())){
            objectMapSaida.put("cartas", cartaDomainList);
        }

        if (Objects.nonNull(baralhoDomain.getRestante())){
            objectMapSaida.put("restante", baralhoDomain.getRestante());
        }
        return objectMapSaida;
    }

    private String booleanToString(Boolean valor){
        if (valor){
            return "sim";
        } return "não";
    }

}
