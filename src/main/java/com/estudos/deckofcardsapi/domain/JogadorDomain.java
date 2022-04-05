package com.estudos.deckofcardsapi.domain;

public class JogadorDomain {

    private String nome;
    private Integer pontos;

    public JogadorDomain(String nome, Integer pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return "{" + nome + '\'' + ", pontos=" + pontos + '}';
    }
}
