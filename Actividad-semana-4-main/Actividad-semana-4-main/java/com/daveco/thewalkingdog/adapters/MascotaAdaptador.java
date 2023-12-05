package com.daveco.thewalkingdog.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daveco.thewalkingdog.R;
import com.daveco.thewalkingdog.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador (ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }


    // adapata cada elemento de nuestra vista con su respectivo view
    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto_perro());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre_mascota());
        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getNum_likes()));

        mascotaViewHolder.imgHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.like();
                mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getNum_likes()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoMascota;
        private ImageView imgHueso;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageView imgHuesoLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota     = itemView.findViewById(R.id.imgMascota);
            imgHueso           = itemView.findViewById(R.id.imgHueso);
            tvNombre           = itemView.findViewById(R.id.tvnameMascotaCV);
            tvLikes            = itemView.findViewById(R.id.tvnumerolikesCV);
            imgHuesoLike       = itemView.findViewById(R.id.imgHuesoLike);
        }
    }
}
