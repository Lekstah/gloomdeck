package com.example.gloomdeck.perk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import androidx.core.content.ContextCompat;

import com.example.gloomdeck.R;

public class Perk {

    Instruction[] instructions;
    String[] words;
    int[] images;

    public Perk(Instruction[] instructions, String[] words, int[] images) {
        this.instructions = instructions;
        this.words = words;
        this.images = images;
    }

    public SpannableStringBuilder getDescription(Context context) {

        SpannableStringBuilder ssb = new SpannableStringBuilder();

        for(int i = 0; i < this.words.length; i++){
            ssb.append(" " + words[i] + "  ");
            if(i < images.length) {

                Drawable drawable = ContextCompat.getDrawable(context, images[i]);
                drawable.setBounds(0, 0, 68, 45);

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
            new Instruction[]{
                    new Instruction(false, R.drawable.card_minus_one),
                    new Instruction(false, R.drawable.card_minus_one)
            },
            new String[]{
                    "Remove two",
                    "cards"
            },
            new int[]{
                    R.drawable.card_minus_one
            }
    );

    public static final Perk REMOVE_FOUR_PLUS_ZERO = new Perk(
            new Instruction[]{
                    new Instruction(false, R.drawable.card_plus_zero),
                    new Instruction(false, R.drawable.card_plus_zero),
                    new Instruction(false, R.drawable.card_plus_zero),
                    new Instruction(false, R.drawable.card_plus_zero)
            },
            new String[]{
                    "Remove four",
                    "cards"
            },
            new int[]{
                    R.drawable.card_plus_zero
            }
    );

    public static final Perk EMPTY_PERK = new Perk(
            new Instruction[]{},
            new String[]{},
            new int[]{}
    );
}
