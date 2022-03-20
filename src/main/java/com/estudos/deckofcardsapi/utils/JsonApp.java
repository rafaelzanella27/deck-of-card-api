package com.estudos.deckofcardsapi.utils;

import com.google.gson.Gson;

public class JsonApp {

    private JsonApp() {

    }

    public static String toJson(Object requestObject) {
        return new Gson().toJson(requestObject);
    }

    public static <T> T fromJson(String json, Class<T> classOfT){
        return new Gson().fromJson(json,classOfT);
    }

}
