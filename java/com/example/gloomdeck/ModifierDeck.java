package com.example.gloomdeck;

import androidx.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ModifierDeck {

    ArrayList<Integer> deck;
    int index;

    public static final int PLUS_ZERO = R.drawable.plus_zero;
    public static final int PLUS_ONE = R.drawable.plus_one;
    public static final int PLUS_TWO = R.drawable.plus_two;
    public static final int MINUS_ONE = R.drawable.minus_one;
    public static final int MINUS_TWO = R.drawable.minus_two;
    public static final int MISS = R.drawable.miss;
    public static final int TIMES_TWO = R.drawable.times_two;


    public ModifierDeck() {

        this.deck = new ArrayList();

        //initialize default deck

        this.deck.add(PLUS_ZERO);

        for(int i = 0; i < 5; i++){
            this.deck.add(PLUS_ZERO);
            this.deck.add(MINUS_ONE);
            this.deck.add(PLUS_ONE);
        }

        this.deck.add(PLUS_TWO);
        this.deck.add(MINUS_TWO);
        this.deck.add(MISS);
        this.deck.add(TIMES_TWO);
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
        this.index = 0;
    }

    public int pop(){
        if(this.index >= this.deck.size())
            return 0;

        return this.deck.get(this.index++);
    }

    public int getRemaining(){
        return this.deck.size() - this.index;
    }

    /**
     * Calculatable attribute.
     * Returns new ArrayList populated by all drawn cards
     * Arranged by latest drawn to 1st drawn.
     *
     * @return
     */
    public ArrayList<Integer> getDrawnCards(){

        ArrayList<Integer> drawnCards = new ArrayList();

        for(int i = this.index - 1; i >= 0; i--)
            drawnCards.add(this.deck.get(i));

        return drawnCards;
    }
}
