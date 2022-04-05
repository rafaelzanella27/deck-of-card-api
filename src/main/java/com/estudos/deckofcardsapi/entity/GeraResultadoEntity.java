package com.estudos.deckofcardsapi.entity;

import com.estudos.deckofcardsapi.entity.adapter.resultados.SomaResultadoFinalToMapAdapter;

import java.util.Map;

public class GeraResultadoEntity {

    private Map<String, Object> retornoApiExterna;
    private Map<String, Object> retornoApiExterna2;
    private Map<String, Object> retornoApiExterna3;
    private Map<String, Object> retornoApiExterna4;

    private GeraResultadoEntity(Map<String, Object> retornoApiExterna, Map<String, Object> retornoApiExterna2, Map<String, Object> retornoApiExterna3, Map<String, Object> retornoApiExterna4){
        this.retornoApiExterna = retornoApiExterna;
        this.retornoApiExterna2 = retornoApiExterna2;
        this.retornoApiExterna3 = retornoApiExterna3;
        this.retornoApiExterna4 = retornoApiExterna4;
    }

    public static GeraResultadoEntity inicializa(Map<String, Object> retornoApiExterna,Map<String, Object> retornoApiExterna2,Map<String, Object> retornoApiExterna3,Map<String, Object> retornoApiExterna4){
        return new GeraResultadoEntity(retornoApiExterna, retornoApiExterna2, retornoApiExterna3, retornoApiExterna4);
    }

    public Map<String, Object> geraResultado(){
            Map<String, Object> saida = SomaResultadoFinalToMapAdapter.inicializa().geraResultado(this.retornoApiExterna, this.retornoApiExterna2, this.retornoApiExterna3, this.retornoApiExterna4);
            return saida ;
    }

}
