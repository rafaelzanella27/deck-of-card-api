package com.estudos.deckofcardsapi.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteComparacao {



    public static void main(String[] args) {

        ArrayList<String> resultadoList = new ArrayList<>();
            String j1 = "3";
            String j2 = "6";
            String j3 = "7";
            String j4 = "3";
            resultadoList.add(j1);
            resultadoList.add(j2);
            resultadoList.add(j3);
            resultadoList.add(j4);
            Collections.sort(resultadoList);
            System.out.println(resultadoList);

        List<String> listaFinal = new ArrayList<>();
        for (String resultado : resultadoList) {
            listaFinal.add(0,resultado);
            listaFinal.add(1,resultado);
            listaFinal.add(2,resultado);
            listaFinal.add(3,resultado);
            System.out.println("Resultado: " + listaFinal);
        }

    }




}
