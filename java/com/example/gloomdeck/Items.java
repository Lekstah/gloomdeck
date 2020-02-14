package com.example.gloomdeck;

import java.util.ArrayList;

public class Items {

    public static final int itemResource[] = {
            0,
            R.drawable.boots_of_striding,
            R.drawable.winged_shoes,
            R.drawable.hide_armor,
            R.drawable.leather_armor,
            R.drawable.cloak_of_invisibility,
            R.drawable.eagle_eye_goggles,
            R.drawable.iron_helmet,
            R.drawable.heater_shield,
            R.drawable.piercing_bow,
            R.drawable.war_hammer,
            R.drawable.poison_dagger,
            R.drawable.minor_healing_potion,
            R.drawable.minor_stamina_potion,
            R.drawable.minor_power_potion
    };

    ArrayList<Integer> items;

    public Items(){
        this.items = new ArrayList();

        items.add(itemResource[1]);
        items.add(itemResource[3]);
        items.add(itemResource[14]);
    }

    public ArrayList<Integer> getItems(){
        return this.items;
    }
}
