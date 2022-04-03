package com.estudos.deckofcardsapi.entity;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.entity.adapter.AdicionaCartaPilhaToMapAdapter;
import com.estudos.deckofcardsapi.entity.adapter.ConverteToBaralhoDomainAdapter;
import com.estudos.deckofcardsapi.entity.adapter.SomaCartasPilhaToMapAdapter;

import java.util.Map;
import java.util.Objects;

public class OperacoesPilhaEntity {

    private Map<String, Object> entrada;
    private String pilha;

    private OperacoesPilhaEntity(Map<String, Object> entrada, String pile_name){
        this.entrada = entrada;
        this.pilha = pile_name;
        this.converteToBaralhoDomain();
    }

    public static OperacoesPilhaEntity inicializa(Map<String, Object> entrada, String pile_name){
        return new OperacoesPilhaEntity(entrada, pile_name);
    }

    public BaralhoDomain converteToBaralhoDomain(){
        BaralhoDomain baralhoDomain = new ConverteToBaralhoDomainAdapter().converte(this.entrada, this.pilha);
        return baralhoDomain;
    }

    public Map<String, Object> geraSaida(){
        BaralhoDomain baralhoDomain = this.converteToBaralhoDomain();
        if (Objects.nonNull(baralhoDomain)){
            Map<String, Object> saida = AdicionaCartaPilhaToMapAdapter.inicializa().execute(baralhoDomain, this.pilha);
            return saida ;
        }
        return null;
    }

    public Map<String, Object> geraSomatoriaCartas(){
        BaralhoDomain baralhoDomain = this.converteToBaralhoDomain();
        if (Objects.nonNull(baralhoDomain)){
            Map<String, Object> saida = SomaCartasPilhaToMapAdapter.inicializa().execute(baralhoDomain, this.pilha);
            return saida ;
        }
        return null;
    }

    public String getPilha(){
        return this.pilha;
    }

    public Map<String, Object> getEntrada(){
        return this.entrada;
    }
}
