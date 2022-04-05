package com.estudos.deckofcardsapi.entity;

import com.estudos.deckofcardsapi.entity.adapter.resultados.SomaResultadoFinalToMapAdapter;

import java.util.Map;

public class GeraResultadoEntity {

    private Map<String, Object> retornoJogador1;
    private Map<String, Object> retornoJogador2;
    private Map<String, Object> retornoJogador3;
    private Map<String, Object> retornoJogador4;

    private GeraResultadoEntity(Map<String, Object> retornoJogador1 ,Map<String, Object> retornoJogador2, Map<String, Object> retornoJogador3, Map<String, Object> retornoJogador4){
        this.retornoJogador1 = retornoJogador1;
        this.retornoJogador2 = retornoJogador2;
        this.retornoJogador3 = retornoJogador3;
        this.retornoJogador4 = retornoJogador4;
    }

    public static GeraResultadoEntity inicializa(Map<String, Object> retornoJogador1 ,Map<String, Object> retornoJogador2, Map<String, Object> retornoJogador3, Map<String, Object> retornoJogador4){
        return new GeraResultadoEntity(retornoJogador1, retornoJogador2, retornoJogador3, retornoJogador4);
    }

    public Map<String, Object> geraResultado(){
            Map<String, Object> saida = SomaResultadoFinalToMapAdapter.inicializa().geraResultado(this.retornoJogador1, this.retornoJogador2, this.retornoJogador3, this.retornoJogador4);
            return saida ;
    }

}
