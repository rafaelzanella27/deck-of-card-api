package com.estudos.deckofcardsapi.utils;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExtensaoJasonApp {

    public Map<String, Object> transforma(String payment) {
        Map<String, Object> objetoTransformado = JsonApp.fromJson(payment, Map.class);
        return objetoTransformado;
    }
}