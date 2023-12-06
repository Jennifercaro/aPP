package com.daveco.thewalkingdog.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daveco.thewalkingdog.adapters.MascotaAdaptador;
import com.daveco.thewalkingdog.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {


    public ListaFragment() {
        // Required empty public constructor
    }
    public class ListFragment extends Fragment {

        private ArrayList<Mascota> mascotas = new ArrayList<>();
        private RecyclerView rvMascotas;

        public ListaFragment() {
            // Required empty public constructor
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.schnauzer, "Jack", 10));
        mascotas.add(new Mascota(R.drawable.french_poodle, "Bob", 7));
        mascotas.add(new Mascota(R.drawable.pastor_alem_n, "Sam", 4));
        mascotas.add(new Mascota(R.drawable.beagle,"Zack", 9));
        mascotas.add(new Mascota(R.drawable.dachshund,"Slinky", 1));
        mascotas.add(new Mascota(R.drawable.labrador,"Chester", 6));
        mascotas.add(new Mascota(R.drawable.pitbull, "Jhonny", 8));
    }

}
