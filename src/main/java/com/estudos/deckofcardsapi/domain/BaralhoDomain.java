package com.estudos.deckofcardsapi.domain;

import java.util.List;

public class BaralhoDomain {

    private Boolean sucesso;
    private String baralho_id;
    private Boolean embaralhado;
    private String restante;
    private List<CartaDomain> cartaDomains;

    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getBaralho_id() {
        return baralho_id;
    }

    public void setBaralho_id(String baralho_id) {
        this.baralho_id = baralho_id;
    }

    public Boolean getEmbaralhado() {
        return embaralhado;
    }

    public void setEmbaralhado(Boolean embaralhado) {
        this.embaralhado = embaralhado;
    }

    public String getRestante() {
        return restante;
    }

    public void setRestante(String restante) {
        this.restante = restante;
    }

    public List<CartaDomain> getCartaDomains() {
        return cartaDomains;
    }

    public void setCartaDomains(List<CartaDomain> cartaDomains) {
        this.cartaDomains = cartaDomains;
    }
}
