package com.example.gloomdeck.perk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import androidx.core.content.ContextCompat;

import com.example.gloomdeck.R;

public class Perk implements Comparable<Perk> {

    String key;
    int[] toAdd;
    int[] toRemove;
    String[] words;
    int[] images;

    public Perk(String key, int[] toRemove, int[] toAdd, String[] words, int[] images) {
        this.key = key;
        this.toAdd = toAdd;
        this.toRemove = toRemove;
        this.words = words;
        this.images = images;
    }

    public String getKey() {
        return key;
    }

    public SpannableStringBuilder getDescription(Context context) {

        SpannableStringBuilder ssb = new SpannableStringBuilder();

        for(int i = 0; i < this.words.length; i++){
            ssb.append(" " + words[i] + "  ");
            if(i < images.length) {

                Drawable drawable = ContextCompat.getDrawable(context, images[i]);
                drawable.setBounds(0, 0, 60, 60);

                ssb.setSpan(
                        new ImageSpan(drawable),
                        ssb.length() - 1,
                        ssb.length(),
                        0
                );
            }
        }

        return ssb;
    }

    public static final Perk REMOVE_TWO_MINUS_ONES = new Perk(
            "REMOVE_TWO_MINUS_ONES",
            new int[]{
                    R.drawable.card_minus_one,
                    R.drawable.card_minus_one
            },
            new int[]{},
            new String[]{ "Remove two", "cards" },
            new int[]{
                    R.drawable.symbol_minus_one
            }
    );

    public static final Perk REMOVE_FOUR_PLUS_ZERO = new Perk(
            "REMOVE_FOUR_PLUS_ZERO",
            new int[]{
                    R.drawable.card_plus_zero,
                    R.drawable.card_plus_zero,
                    R.drawable.card_plus_zero,
                    R.drawable.card_plus_zero
            },
            new int[]{},
            new String[]{ "Remove four", "cards" },
            new int[]{
                    R.drawable.symbol_plus_zero
            }
    );

    public static final Perk REPLACE_TWO_PLUS_ONE_WITH_TWO_PLUS_TWO = new Perk(
            "REPLACE_TWO_PLUS_ONE_WITH_TWO_PLUS_TWO",
            new int[]{
                    R.drawable.card_plus_one,
                    R.drawable.card_plus_one
            },
            new int[]{
                    R.drawable.card_plus_two,
                    R.drawable.card_plus_two
            },
            new String[]{ "Replace two", "with two", "cards" },
            new int[]{
                    R.drawable.symbol_plus_one,
                    R.drawable.symbol_plus_two
            }
    );

    public static final Perk REPLACE_MINUS_TWO_WITH_PLUS_ZERO = new Perk(
            "REPLACE_MINUS_TWO_WITH_PLUS_ZERO",
            new int[]{
                    R.drawable.card_minus_two
            },
            new int[]{
                    R.drawable.card_plus_zero
            },
            new String[]{ "Replace one", "with one", "cards" },
            new int[]{
                    R.drawable.symbol_minus_two,
                    R.drawable.symbol_plus_zero
            }
    );

    public static final Perk ADD_PLUS_TWO_ICE = new Perk(
            "ADD_PLUS_TWO_ICE",
            new int[]{},
            new int[]{},
            new String[]{"Add one", "", "card"},
            new int[]{
                    R.drawable.symbol_plus_two,
                    R.drawable.ic_symbol_ice
            }
    );

    public static final Perk ADD_TWO_ROLLING_PLUS_ONE = new Perk(
            "ADD_TWO_ROLLING_PLUS_ONE",
            new int[]{},
            new int[]{},
            new String[]{"Add two", "", "cards"},
            new int[]{
                    R.drawable.ic_symbol_rolling,
                    R.drawable.symbol_plus_one
            }
    );

    public static final Perk EMPTY_PERK = new Perk(
            "EMPTY_PERK",
            new int[]{},
            new int[]{},
            new String[]{},
            new int[]{}
    );

    @Override
    public int compareTo(Perk o) {
        return this.key.compareTo(o.key);
    }
}