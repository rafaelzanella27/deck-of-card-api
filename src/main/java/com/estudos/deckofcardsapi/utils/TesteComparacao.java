package com.estudos.deckofcardsapi.utils;

import com.estudos.deckofcardsapi.domain.JogadorDomain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TesteComparacao {



    public static void main(String[] args) {

        List<JogadorDomain> resultadoList = new ArrayList<>();
            String j1 = "jogador1";
            String j2 = "jogador2";
            String j3 = "jogador3";
            String j4 = "jogador4";
            resultadoList.add(new JogadorDomain(j1,33));
            resultadoList.add(new JogadorDomain(j2,6));
            resultadoList.add(new JogadorDomain(j3,7));
            resultadoList.add(new JogadorDomain(j4,3));

            resultadoList.sort(Comparator.comparingInt(JogadorDomain::getPontos));

            System.out.println(resultadoList);


    }




}
