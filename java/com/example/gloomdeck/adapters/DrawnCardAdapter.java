package com.example.gloomdeck.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gloomdeck.R;

import java.util.ArrayList;

public class DrawnCardAdapter extends RecyclerView.Adapter <DrawnCardAdapter.DrawnCardViewHolder> {

    private ArrayList<Integer> drawnCards;
    private DrawnCardClickListener drawnCardClickListener;

    public DrawnCardAdapter(ArrayList<Integer> drawnCards){
        this.drawnCards = drawnCards;
    }

    class DrawnCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;

//        DrawnCardViewHolder(View itemView){
//            super(itemView);
//            imageView = itemView.findViewById(R.id.drawnCardImg);
//        }

        public DrawnCardViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.drawnCardImg);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (drawnCardClickListener != null) drawnCardClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface DrawnCardClickListener {
        void onItemClick(View view, int position);
    }

    public void setDrawnCardClickListener(DrawnCardClickListener drawnCardClickListener) {
        this.drawnCardClickListener = drawnCardClickListener;
    }

    public void setDrawnCards(ArrayList<Integer> drawnCards) {
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
