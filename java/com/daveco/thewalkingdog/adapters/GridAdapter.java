package com.daveco.thewalkingdog.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daveco.thewalkingdog.pojo.Mascota;

import java.util.ArrayList;

public class PetGridAdapter extends RecyclerView.Adapter<PetGridAdapter.PetViewHolder> {
    private ArrayList<Mascota> mascotas;

    public PetGridAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas =  mascotas;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_list_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.ivImage.setImageResource(mascota.getImage());
        holder.tvPetRating.setText(String.valueOf(mascota.getRating()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvPetRating;

        public PetViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvPetRating = itemView.findViewById(R.id.tv_rating);
        }
    }
}