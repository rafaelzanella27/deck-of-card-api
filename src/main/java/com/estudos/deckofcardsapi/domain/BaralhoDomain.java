package com.estudos.deckofcardsapi.domain;

import java.util.List;
import java.util.Map;

public class BaralhoDomain {

    private String sucesso;
    private String baralho_id;
    private String embaralhado;
    private Integer restante;
    private List<Map<String, Object>> cartas;
    private Map<String, Object> pilhas;

    public Map<String, Object> getPilhas() {
        return pilhas;
    }

    public void setPilhas(Map<String, Object> pilhas) {
        this.pilhas = pilhas;
    }

    public String getSucesso() {
        return sucesso;
    }

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }

    public String getBaralho_id() {
        return baralho_id;
    }

    public void setBaralho_id(String baralho_id) {
        this.baralho_id = baralho_id;
    }

    public String getEmbaralhado() {
        return embaralhado;
    }

    public void setEmbaralhado(String embaralhado) {
        this.embaralhado = embaralhado;
    }

    public Integer getRestante() {
        return restante;
    }

    public void setRestante(Integer restante) {
        this.restante = restante;
    }

    public List<Map<String, Object>> getCartas() {
        return cartas;
    }

    public void setCartas(List<Map<String, Object>> cartas) {
        this.cartas = cartas;
    }
}
