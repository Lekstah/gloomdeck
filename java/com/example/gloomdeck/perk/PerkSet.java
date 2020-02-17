package com.example.gloomdeck.perk;

public class PerkSet {

    Perk perk;
    int checkboxCount;
    boolean firstChecked;
    boolean secondChecked;
    boolean thirdChecked;

    public PerkSet(int checkboxCount, Perk perk) {
        this.perk = perk;
        this.checkboxCount = checkboxCount;
        this.firstChecked = false;
        this.secondChecked = false;
        this.thirdChecked = false;
    }

    public Perk getPerk() {
        return perk;
    }

    public int getCheckboxCount() {
        return checkboxCount;
    }

    public boolean isFirstChecked() {
        return this.firstChecked;
    }

    public boolean isSecondChecked() {
        return (checkboxCount < 2) ? false : this.secondChecked;
    }

    public boolean isThirdChecked() {
        return (checkboxCount < 3) ? false : this.thirdChecked;
    }

    public void setFirstChecked(boolean firstChecked) {
        this.firstChecked = firstChecked;
    }

    public void setSecondChecked(boolean secondChecked) {
        this.secondChecked = secondChecked;
    }

    public void setThirdChecked(boolean thirdChecked) {
        this.thirdChecked = thirdChecked;
    }
}
