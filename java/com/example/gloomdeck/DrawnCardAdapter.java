package com.example.gloomdeck;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrawnCardAdapter extends RecyclerView.Adapter <DrawnCardAdapter.DrawnCardViewHolder> {

    private ArrayList<Integer> drawnCards;

    public static class DrawnCardViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;

        DrawnCardViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.drawnCardImg);
        }
    }

    public DrawnCardAdapter(ArrayList<Integer> drawnCards){
        this.drawnCards = drawnCards;
    }

    @NonNull
    @Override
    public DrawnCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawn_card, parent, false);
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
