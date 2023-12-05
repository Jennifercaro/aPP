package com.daveco.thewalkingdog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.daveco.thewalkingdog.adapters.MascotaAdaptador;
import com.daveco.thewalkingdog.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList <Mascota> mascotasFav;
    private RecyclerView listMascotasFav;
    public MascotaAdaptador adapterRated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miactionBar2 = findViewById(R.id.miActionBar);
        setSupportActionBar(miactionBar2);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.pata);
        //getSupportActionBar().setTitle(R.string.app_name);

        listMascotasFav = findViewById(R.id.rvMascotasFavs);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listMascotasFav.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adapterRated = new MascotaAdaptador(mascotasFav, this);
        listMascotasFav.setAdapter(adapterRated);
    }

    public void inicializarListaMascotas (){
        mascotasFav = new ArrayList<Mascota>();
        mascotasFav.add(new Mascota(R.drawable.schnauzer, "Jack", 10));
        mascotasFav.add(new Mascota(R.drawable.beagle,"Zack", 9));
        mascotasFav.add(new Mascota(R.drawable.pitbull, "Jhonny", 8));
        mascotasFav.add(new Mascota(R.drawable.french_poodle, "Bob", 7));
        mascotasFav.add(new Mascota(R.drawable.labrador,"Chester", 6));
    }

    public void onClickBack(View view) {
        onBackPressed();
    }
}
