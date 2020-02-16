package com.example.gloomdeck;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrawnModifierAdapter extends RecyclerView.Adapter <DrawnModifierAdapter.DrawnCardViewHolder> {

    private ArrayList<Integer> drawnCards;

    public DrawnModifierAdapter(ArrayList<Integer> drawnCards){
        this.drawnCards = drawnCards;
    }

    class DrawnCardViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public DrawnCardViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.drawnModifierImg);
        }
    }

    public void setDrawnCards(ArrayList<Integer> drawnCards) {
        this.drawnCards = drawnCards;
    }

    @NonNull
    @Override
    public DrawnCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawn_modifier, parent, false);
        DrawnCardViewHolder dcvh = new DrawnCardViewHolder(v);
        return dcvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DrawnCardViewHolder holder, int position) {
        holder.imageView.setImageResource(drawnCards.get(position));
    }

    @Override
    public int getItemCount() {
        return drawnCards.size();
    }

}
