package com.example.gloomdeck.perk;

public class PerkSet {

    Perk perk;
    int checkboxCount;

    public PerkSet(int checkboxCount, Perk perk) {
        this.perk = perk;
        this.checkboxCount = checkboxCount;
    }

    public Perk getPerk() {
        return perk;
    }

    public int getCheckboxCount() {
        return checkboxCount;
    }
}
