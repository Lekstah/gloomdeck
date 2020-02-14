package com.example.gloomdeck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView countView;
    FloatingActionButton shuffleButton;
    RecyclerView drawnCardsRecycler;
    RecyclerView itemRecyclerView;

    ModifierDeck deck;
    Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        countView = findViewById(R.id.countView);
        shuffleButton = findViewById(R.id.shuffleButton);

        deck = new ModifierDeck();
        items = new Items();

        drawnCardsRecycler = findViewById(R.id.drawnCardsRecycler);
        drawnCardsRecycler.setHasFixedSize(true);
        drawnCardsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        drawnCardsRecycler.setAdapter(new DrawnCardAdapter(new ArrayList()));

        itemRecyclerView = findViewById(R.id.itemRecyclerView);
        itemRecyclerView.setHasFixedSize(true);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        itemRecyclerView.setAdapter(new DrawnCardAdapter(items.getItems()));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("asdasda", "henlo");
                //imageView.setImageResource(deck.pop());
                deck.pop();
                drawnCardsRecycler.setAdapter(
                        new DrawnCardAdapter(deck.getDrawnCards())
                );
                countView.setText("" + deck.getRemaining());
            }
        });

        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.shuffle();
                //imageView.setImageResource(R.drawable.mod_back);
                drawnCardsRecycler.setAdapter(
                        new DrawnCardAdapter(deck.getDrawnCards())
                );
                countView.setText("" + deck.getRemaining());
            }
        });
    }
}
