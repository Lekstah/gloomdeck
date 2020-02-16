package com.example.gloomdeck.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gloomdeck.R;
import com.example.gloomdeck.perk.PerkSet;

import java.util.ArrayList;

public class PerkListAdapter extends RecyclerView.Adapter <PerkListAdapter.PerkViewHolder> {

    private PerkSet[] perks;

    public PerkListAdapter(PerkSet[] perks) {
        this.perks = perks;
    }

    class PerkViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public CheckBox checkBox1;
        public CheckBox checkBox2;
        public CheckBox checkBox3;

        public PerkViewHolder(@NonNull final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.perk_text_view);
            checkBox1 = itemView.findViewById(R.id.checkbox_1);
            checkBox2 = itemView.findViewById(R.id.checkbox_2);
            checkBox3 = itemView.findViewById(R.id.checkbox_3);
        }
    }

    public void setPerks(PerkSet[] perks) {
        this.perks = perks;
    }

    @NonNull
    @Override
    public PerkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.perk_layout, parent, false);
        PerkViewHolder dcvh = new PerkViewHolder(v);
        return dcvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PerkViewHolder holder, int position) {

        PerkSet perk = perks[position];

        if(perk.getCheckboxCount() > 1)
            holder.checkBox2.setVisibility(View.VISIBLE);
        if(perk.getCheckboxCount() > 2)
            holder.checkBox3.setVisibility(View.VISIBLE);

        holder.textView.setText(perk.getPerk().getDescription(holder.textView.getContext()));
    }

    @Override
    public int getItemCount() {
        return perks.length;
    }

}
