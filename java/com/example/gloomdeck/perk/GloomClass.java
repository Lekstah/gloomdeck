package com.example.gloomdeck.perk;

public class GloomClass {

    String className;
    PerkSet[] perks;

    public GloomClass(String className, PerkSet[] perks) {
        this.className = className;
        this.perks = perks;
    }

    public String getClassName() {
        return className;
    }

    public PerkSet[] getPerks() {
        return perks;
    }

    public static final GloomClass MINDTHIEF = new GloomClass(
            "Mindthief",
            new PerkSet[]{
                    new PerkSet(2, Perk.REMOVE_TWO_MINUS_ONES),
                    new PerkSet(1, Perk.REMOVE_FOUR_PLUS_ZERO),
                    new PerkSet(1, Perk.REPLACE_TWO_PLUS_ONE_WITH_TWO_PLUS_TWO),
                    new PerkSet(1, Perk.REPLACE_MINUS_TWO_WITH_PLUS_ZERO),
                    new PerkSet(2, Perk.ADD_PLUS_TWO_ICE),
                    new PerkSet(2, Perk.ADD_TWO_ROLLING_PLUS_ONE)
            }
    );

    public static final GloomClass SPELLWEAVER = new GloomClass(
            "Spellweaver",
            new PerkSet[]{
                  new PerkSet(1, Perk.REMOVE_FOUR_PLUS_ZERO)
            }
    );

    public static GloomClass[] classes = {MINDTHIEF, SPELLWEAVER};
}
