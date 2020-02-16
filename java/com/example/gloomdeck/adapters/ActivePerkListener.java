package com.example.gloomdeck.adapters;

import com.example.gloomdeck.perk.Perk;

public interface ActivePerkListener {
	void onPerkActivate(Perk changedPerk, boolean isChecked);
}
