package com.example.gloomdeck.perk;

public class GloomClass {

    String className;
    PerkSet[] perks;

    public GloomClass(String className, PerkSet[] perks) {
        this.className = className;
        this.perks = perks;
    }

    public PerkSet[] getPerks() {
        return perks;
    }

    public static final GloomClass MINDTHIEF = new GloomClass(
            "Mindthief",
            new PerkSet[]{
                    new PerkSet(2, Perk.REMOVE_TWO_MINUS_ONES),
                    new PerkSet(1, Perk.REMOVE_FOUR_PLUS_ZERO)
            }
    );

    public static final GloomClass SPELLWEAVER = new GloomClass(
            "Spellweaver",
            new PerkSet[]{
                  new PerkSet(1, Perk.REMOVE_FOUR_PLUS_ZERO)
            }
    );
}
