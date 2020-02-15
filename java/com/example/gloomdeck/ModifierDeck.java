package com.example.gloomdeck;

import java.util.ArrayList;
import java.util.Collections;

public class ModifierDeck {

    ArrayList<Integer> deck;
    int index;

    public static final int PLUS_ZERO = R.drawable.card_plus_zero;
    public static final int PLUS_ONE = R.drawable.card_plus_one;
    public static final int PLUS_TWO = R.drawable.card_plus_two;
    public static final int MINUS_ONE = R.drawable.card_minus_one;
    public static final int MINUS_TWO = R.drawable.card_minus_two;
    public static final int MISS = R.drawable.card_miss;
    public static final int TIMES_TWO = R.drawable.card_times_two;
    public static final int MOD_BLESS = R.drawable.card_mod_bless;
    public static final int MOD_CURSE = R.drawable.card_mod_curse;
    public static final int MOD_MINUS_ONE = R.drawable.card_mod_minus_one;


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

    public void addCard(Integer card) {
        deck.add(card);
    }

    public void removeCard(Integer card) {
        deck.remove(card);
    }
}
