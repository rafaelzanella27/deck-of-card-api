package com.estudos.deckofcardsapi.enums;

public enum ValorType {

    ACE(1),
    JACK(11),
    QUEEN(12),
    KING(13);

    private Integer valor;

    ValorType(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public static Integer converteValor(String value) {
        for (ValorType valorType: ValorType.values()) {
            if (valorType.toString().equalsIgnoreCase(value)){
                return valorType.getValor();
            }
        }
        return Integer.parseInt(value);
    }


}
