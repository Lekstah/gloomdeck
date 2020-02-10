package com.example.gloomdeck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView countView;
    Button shuffleButton;
    ModifierDeck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        countView = findViewById(R.id.countView);
        shuffleButton = findViewById(R.id.shuffleButton);

        deck = new ModifierDeck();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("asdasda", "henlo");
                imageView.setImageResource(deck.pop());
                countView.setText("" + deck.getRemaining());
            }
        });

        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.shuffle();
                imageView.setImageResource(R.drawable.mod_back);
                countView.setText("" + deck.getRemaining());
            }
        });
    }
}
