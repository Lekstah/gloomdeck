package com.example.gloomdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gloomdeck.adapters.PerkListAdapter;
import com.example.gloomdeck.perk.GloomClass;

public class ModifierActivity extends AppCompatActivity {

    RecyclerView perkRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);

        perkRecyclerView = findViewById(R.id.perk_recycler_view);
        perkRecyclerView.setHasFixedSize(true);
        perkRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        perkRecyclerView.setAdapter(new PerkListAdapter(GloomClass.MINDTHIEF.getPerks()));

    }
}
