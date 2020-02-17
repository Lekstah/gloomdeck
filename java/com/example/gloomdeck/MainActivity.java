package com.example.gloomdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gloomdeck.adapters.DrawnCardAdapter;
import com.example.gloomdeck.adapters.DrawnModifierAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DrawnCardAdapter.DrawnCardClickListener {

    ImageView imageView;
    TextView countView;
    FloatingActionButton shuffleButton;
    FloatingActionButton manageModifiersButton;
    RecyclerView drawnCardsRecycler;
    RecyclerView itemRecyclerView;

    DrawnModifierAdapter cardsAdapter;
    DrawnCardAdapter itemsAdapter;

    ImageView btnBless;
    ImageView btnCurse;

    ModifierDeck deck;
    Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.deck_image_view);
        countView = findViewById(R.id.countView);
        shuffleButton = findViewById(R.id.shuffleButton);
        manageModifiersButton = findViewById(R.id.settings_button);
        btnBless = findViewById(R.id.blessButton);
        btnCurse = findViewById(R.id.curseButton);

        deck = new ModifierDeck();
        items = new Items();

        cardsAdapter = new DrawnModifierAdapter(new ArrayList<Integer>());
        itemsAdapter = new DrawnCardAdapter(items.getItems());
        itemsAdapter.setDrawnCardClickListener(this);

        drawnCardsRecycler = findViewById(R.id.drawnCardsRecycler);
        drawnCardsRecycler.setHasFixedSize(true);
        drawnCardsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        drawnCardsRecycler.setAdapter(cardsAdapter);

        itemRecyclerView = findViewById(R.id.itemRecyclerView);
        itemRecyclerView.setHasFixedSize(true);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        itemRecyclerView.setAdapter(itemsAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pop = deck.pop();
                if (pop > -1) {
                    cardsAdapter.setDrawnCards(deck.getDrawnCards());
                    cardsAdapter.notifyItemInserted(0);
                    drawnCardsRecycler.scrollToPosition(0);
                    countView.setText("" + deck.getRemaining());
                }
            }
        });

        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.shuffle();
                cardsAdapter.setDrawnCards(deck.getDrawnCards());
                cardsAdapter.notifyDataSetChanged();
                countView.setText("" + deck.getRemaining());
            }
        });

        btnBless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.addCard(deck.MOD_BLESS);
                countView.setText("" + deck.getRemaining());
            }
        });

        btnCurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.addCard(deck.MOD_CURSE);
                countView.setText("" + deck.getRemaining());
            }
        });

        manageModifiersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openModifierActivity();
            }
        });
    }

    public void openModifierActivity(){
        Intent intent = new Intent(this, ModifierActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e("view onItemClick", "" + view.getParent().getClass() + " " + position);
    }
}
