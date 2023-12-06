package com.daveco.thewalkingdog.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daveco.thewalkingdog.R;
import com.daveco.thewalkingdog.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class GridFragment extends Fragment {
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private RecyclerView rvMascotas;
    private CircularImageView civ_pet_imagen;
    private TextView tv_pet_name;
}

    public GridFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_list, container, false);
        rvMascotas = view.findViewById(R.id.rv_pet_grid_list);
        civ_pet_imagen = view.findViewById(R.id.civ_pet_image);
        tv_pet_name = view.findViewById(R.id.tv_pet_name);

        Mascota dummyPet = new Mascota(R.drawable.first_pet,"Jack",0);
        civ_pet_imagen.setImageResource(dummyPet.getImage());
        tv_pet_name.setText(dummyPet.getName());

        GridLayoutManager dlm = new GridLayoutManager(getActivity(),3);
        dlm.setOrientation(GridLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(dlm);
        initializeList();
        initializeAdapter();
        return view;
    }

    private void initializeList(){
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 14));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 28));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 1));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 7));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 5));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 8));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 12));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 15));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 45));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 6));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 0));
        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 9));
    }

    private void initializeAdapter(){
        PetGridAdapter pa = new PetGridAdapter(pets);
        rvPets.setAdapter(pa);
    }

}
