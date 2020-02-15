package com.example.gloomdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DrawnCardAdapter.DrawnCardClickListener {

    ImageView imageView;
    TextView countView;
    FloatingActionButton shuffleButton;
    RecyclerView drawnCardsRecycler;
    RecyclerView itemRecyclerView;

    DrawnCardAdapter cardsAdapter;
    DrawnCardAdapter itemsAdapter;

    Button btnBless;
    Button btnCurse;

    ModifierDeck deck;
    Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.deck_image_view);
        countView = findViewById(R.id.countView);
        shuffleButton = findViewById(R.id.shuffleButton);
        btnBless = findViewById(R.id.button_bless);
        btnCurse = findViewById(R.id.button_curse);

        deck = new ModifierDeck();
        items = new Items();

        cardsAdapter = new DrawnCardAdapter(new ArrayList<Integer>());
        cardsAdapter.setDrawnCardClickListener(this);
        itemsAdapter = new DrawnCardAdapter(items.getItems());
        itemsAdapter.setDrawnCardClickListener(this);

        drawnCardsRecycler = findViewById(R.id.drawnCardsRecycler);
        drawnCardsRecycler.setHasFixedSize(true);
        drawnCardsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        drawnCardsRecycler.setAdapter(cardsAdapter);

        itemRecyclerView = findViewById(R.id.itemRecyclerView);
        itemRecyclerView.setHasFixedSize(true);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        itemRecyclerView.setAdapter(itemsAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.pop();
//                drawnCardsRecycler.setAdapter(
//                        new DrawnCardAdapter(deck.getDrawnCards())
//                );
                cardsAdapter.setDrawnCards(deck.getDrawnCards());
                cardsAdapter.notifyItemInserted(0);
                drawnCardsRecycler.scrollToPosition(0);
                countView.setText("" + deck.getRemaining());
            }
        });

        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.shuffle();
//                drawnCardsRecycler.setAdapter(
//                        new DrawnCardAdapter(deck.getDrawnCards())
//                );
                cardsAdapter.setDrawnCards(deck.getDrawnCards());
                cardsAdapter.notifyDataSetChanged();
                countView.setText("" + deck.getRemaining());
            }
        });

        btnBless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.addCard(deck.MOD_BLESS);
                deck.shuffle();
                cardsAdapter.setDrawnCards(deck.getDrawnCards());
                cardsAdapter.notifyDataSetChanged();
                countView.setText("" + deck.getRemaining());
            }
        });

        btnCurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.addCard(deck.MOD_CURSE);
                deck.shuffle();
                cardsAdapter.setDrawnCards(deck.getDrawnCards());
                cardsAdapter.notifyDataSetChanged();
                countView.setText("" + deck.getRemaining());
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e("view onItemClick", "" + view.getParent().getClass() + " " + position);
    }
}
