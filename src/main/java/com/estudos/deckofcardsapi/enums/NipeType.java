package com.estudos.deckofcardsapi.enums;

public enum NipeType {

    SPADES("ESPADAS"),
    HEARTS("COPAS"),
    CLUBS("PAUS"),
    DIAMONDS("OUROS");

    private String nipe;

    NipeType(String nipe) {
        this.nipe = nipe;
    }

    public String getNipe() {
        return nipe;
    }

    public static String converteNipe(String value) {
        for (NipeType nipeType: NipeType.values()) {
            if (nipeType.toString().equalsIgnoreCase(value)){
                return nipeType.getNipe();
            }
        }
        return null;
    }


}
