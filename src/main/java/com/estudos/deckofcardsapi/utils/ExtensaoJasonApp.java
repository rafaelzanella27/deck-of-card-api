package com.estudos.deckofcardsapi.utils;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExtensaoJasonApp {

    public Map<String, Object> transforma(String payment) {
        Map<String, Object> objetoTransformado = JsonApp.fromJson(payment, Map.class);
        return objetoTransformado;
    }

    public String transformaObjetoEmStringJson(BaralhoDomain baralhoDomain) {
        return JsonApp.toJson(baralhoDomain);
    }

}