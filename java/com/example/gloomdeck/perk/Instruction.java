package com.example.gloomdeck.perk;

public class Instruction {

    /**
     * true for add
     * false for remove
     */
    boolean add;
    int cardResource;

    public Instruction(boolean add, int cardResource) {
        this.add = add;
        this.cardResource = cardResource;
    }

    public boolean isAdd() {
        return add;
    }

    public int getCardResource() {
        return cardResource;
    }
}
