package com.example.gloomdeck.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gloomdeck.R;
import com.example.gloomdeck.perk.Perk;
import com.example.gloomdeck.perk.PerkSet;

public class PerkListAdapter extends RecyclerView.Adapter <PerkListAdapter.PerkViewHolder> implements ActivePerkListener {

    private PerkSet[] perks;
    ActivePerkListener activePerkListener;

    public PerkListAdapter(PerkSet[] perks, ActivePerkListener activePerkListener) {
        this.perks = perks;
        this.activePerkListener = activePerkListener;
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
        Log.e("setPerks", "called");
        for (int i=0 ; i<perks.length ; i++) {
            Log.e("perks", i + " c: " + perks[i].getCheckboxCount() + " f " + perks[i].isFirstChecked());
        }
    }

    @NonNull
    @Override
    public PerkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.perk_layout, parent, false);
        PerkViewHolder dcvh = new PerkViewHolder(v);
        return dcvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final PerkViewHolder holder, int position) {

        final PerkSet thisPerk = perks[position];

        if (thisPerk.getCheckboxCount() > 1) holder.checkBox2.setVisibility(View.VISIBLE);
        else holder.checkBox2.setVisibility(View.GONE);
        if (thisPerk.getCheckboxCount() > 2) holder.checkBox3.setVisibility(View.VISIBLE);
        else holder.checkBox3.setVisibility(View.GONE);

        holder.textView.setText(thisPerk.getPerk().getDescription(holder.textView.getContext()));

        Log.e("onBindViewHolder", "test");
        if (thisPerk.getPerk().getKey().equals(Perk.REMOVE_FOUR_PLUS_ZERO.getKey())) {
            Log.e("ASD", thisPerk.isFirstChecked() + " " + thisPerk.isSecondChecked() + " " + thisPerk.isThirdChecked());
        }

        if (holder.checkBox1.getVisibility() == View.VISIBLE) {
            holder.checkBox1.setChecked(thisPerk.isFirstChecked());
            holder.checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) thisPerk.setFirstChecked(true);
                    else thisPerk.setFirstChecked(false);
                    Log.e("onCheckedChanged", "" + holder.getAdapterPosition() + " checkbox 1 " + isChecked);
                    activePerkListener.onPerkActivate(thisPerk.getPerk(), isChecked);
                }
            });
        }
        if (holder.checkBox2.getVisibility() == View.VISIBLE) {
            holder.checkBox2.setChecked(thisPerk.isSecondChecked());
            holder.checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) thisPerk.setSecondChecked(true);
                    else thisPerk.setSecondChecked(false);
                    Log.e("onCheckedChanged", "Perk " + holder.getAdapterPosition() + " checkbox 2 " + isChecked);
                    activePerkListener.onPerkActivate(thisPerk.getPerk(), isChecked);
                }
            });
        }
        if (holder.checkBox3.getVisibility() == View.VISIBLE) {
            holder.checkBox3.setChecked(thisPerk.isThirdChecked());
            holder.checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) thisPerk.setThirdChecked(true);
                    else thisPerk.setThirdChecked(false);
                    Log.e("onCheckedChanged", "" + holder.getAdapterPosition() + " checkbox 3 " + isChecked);
                    activePerkListener.onPerkActivate(thisPerk.getPerk(), isChecked);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return perks.length;
    }

    /**
     * Listener func, alert listener that a perk has been activated/deactivated
     * @param changedPerk
     * @param isChecked
     */
    @Override
    public void onPerkActivate(Perk changedPerk, boolean isChecked) {
        this.activePerkListener.onPerkActivate(changedPerk, isChecked);
    }

}
