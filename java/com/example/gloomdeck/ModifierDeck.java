package com.example.gloomdeck;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ModifierDeck {

    ArrayList<Integer> deck;
    int index;
    static Random rand;

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
        this.rand = new Random();

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

    /**
     *  Removes drawn bless/curse cards from the deck, taking into account
     *  index shifting, and shuffles the rest of the cards.
     */
    public void shuffle(){
        int drawnBless = 0, drawnCurse = 0;
        for (int i = 0 ; i < this.index ; i++){
            if (this.deck.get(i) == MOD_BLESS) drawnBless++;
            else if (this.deck.get(i) == MOD_CURSE) drawnCurse++;
        }
        while (drawnBless > 0) {
            deck.remove(deck.lastIndexOf(MOD_BLESS));
            drawnBless--;
        }
        while (drawnCurse > 0) {
            deck.remove(deck.lastIndexOf(MOD_CURSE));
            drawnCurse--;
        }

        Collections.shuffle(this.deck);
        this.index = 0;
    }

    public int pop(){
        if(this.index >= this.deck.size())
            return -1;

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

    /**
     * Adds card to a random index in the undrawn
     * part of the deck
     * @param card - Card to be added
     */
    public void addCard(Integer card) {
        int randomIndex = getRandomNumberInRange(this.index, deck.size());
        Log.e("addCard to index", "" + randomIndex);
        deck.add(randomIndex, card);
    }

    /**
     * Removes one occurrence of card in the deck, if any.
     * @param card
     */
    public void removeCard(Integer card) {
        try {
            deck.remove(deck.indexOf(card));
        } catch (IndexOutOfBoundsException e) {
            // card not found in deck
            e.printStackTrace();
        }
    }

    /**
     * Generates a random number from min to max -1,
     * [min ... max), where min < max
     * @param min
     * @param max
     * @return
     */
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return rand.nextInt((max - min) + 1) + min;
    }
}
