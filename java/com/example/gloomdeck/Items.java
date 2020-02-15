package com.example.gloomdeck;

import java.util.ArrayList;

public class Items {

    public static final int itemResource[] = {
            0,
            R.drawable.item_boots_of_striding,
            R.drawable.item_winged_shoes,
            R.drawable.item_hide_armor,
            R.drawable.item_leather_armor,
            R.drawable.item_cloak_of_invisibility,
            R.drawable.item_eagle_eye_goggles,
            R.drawable.item_iron_helmet,
            R.drawable.item_heater_shield,
            R.drawable.item_piercing_bow,
            R.drawable.item_war_hammer,
            R.drawable.item_poison_dagger,
            R.drawable.item_minor_healing_potion,
            R.drawable.item_minor_stamina_potion,
            R.drawable.item_minor_power_potion
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
