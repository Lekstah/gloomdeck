package com.example.gloomdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.example.gloomdeck.adapters.ActivePerkListener;
import com.example.gloomdeck.adapters.ClassSpinnerAdapter;
import com.example.gloomdeck.adapters.PerkListAdapter;
import com.example.gloomdeck.perk.GloomClass;
import com.example.gloomdeck.perk.Perk;

import java.util.ArrayList;

public class ModifierActivity extends AppCompatActivity implements ActivePerkListener {

    RecyclerView perkRecyclerView;
    Spinner spinner;

    ArrayList<Perk> activePerks; // add to this list when any checkbox in the currently shown perks is checked

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);

        activePerks = new ArrayList<Perk>();

        perkRecyclerView = findViewById(R.id.perk_recycler_view);
        perkRecyclerView.setHasFixedSize(true);
        perkRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final PerkListAdapter perkListAdapter = new PerkListAdapter(GloomClass.classes[0].getPerks(), this);
        perkRecyclerView.setAdapter(perkListAdapter);

        spinner = findViewById(R.id.classes_spinner);
        final ArrayAdapter spinnerAdapter = new ClassSpinnerAdapter(this, android.R.layout.simple_spinner_item, GloomClass.classes);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GloomClass selectedClass = (GloomClass) spinnerAdapter.getItem(position);
                perkRecyclerView.setAdapter(null);
                perkListAdapter.setPerks(selectedClass.getPerks());
//                perkListAdapter.notifyDataSetChanged();
                perkRecyclerView.setAdapter(perkListAdapter);
                activePerks = new ArrayList<Perk>();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    @Override
    public void onPerkActivate(Perk changedPerk, boolean isChecked) {
        if (isChecked)
            activePerks.add(changedPerk);
        else
            activePerks.remove(changedPerk);

        Log.e("onPerkActivate", "PERKS:");
        for (Perk perk : activePerks) {
            Log.e("activePerks", perk.getKey());
        }
    }

    @Override
    protected void onDestroy() {
        Log.e("onDestroy", "PERKS:");
        for (Perk perk : activePerks) {
            Log.e("activePerks", perk.getKey());
        }
        // send?
        super.onDestroy();
    }
}
