package com.estudos.deckofcardsapi.entity;

import com.estudos.deckofcardsapi.domain.BaralhoDomain;
import com.estudos.deckofcardsapi.entity.adapter.ListarBaralhoCriadoToMapAdapter;
import com.estudos.deckofcardsapi.entity.adapter.ConverteToBaralhoDomainAdapter;

import java.util.Map;
import java.util.Objects;

public class ListarPilhaEntity {

    private Map<String, Object> entrada;
    private String pilha;

    private ListarPilhaEntity(Map<String, Object> entrada, String pile_name){
        this.entrada = entrada;
        this.pilha = pile_name;
        this.converteToBaralhoDomain();
    }

    public static ListarPilhaEntity inicializa(Map<String, Object> entrada, String pile_name){
        return new ListarPilhaEntity(entrada, pile_name);
    }

    public BaralhoDomain converteToBaralhoDomain(){
        BaralhoDomain baralhoDomain = new ConverteToBaralhoDomainAdapter().converte(this.entrada, this.pilha);
        return baralhoDomain;
    }

    public Map<String, Object> geraSaida(){
        BaralhoDomain baralhoDomain = this.converteToBaralhoDomain();
        if (Objects.nonNull(baralhoDomain)){
            Map<String, Object> saida = ListarBaralhoCriadoToMapAdapter.inicializa().converte(baralhoDomain, this.pilha);
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
