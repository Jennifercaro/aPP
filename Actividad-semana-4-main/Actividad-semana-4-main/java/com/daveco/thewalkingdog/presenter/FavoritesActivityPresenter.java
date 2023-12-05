package com.daveco.thewalkingdog.presenter;

import android.content.Context;

public class FavoritesActivityPresenter implements IFavoritesActivityPresenter {

    private IFavoritesActivityView viewModel;
    private Context context;
    private ConstructorPet constructorMascotas;

    public FavoritesActivityPresenter(IFavoritesActivityView viewModel, Context context) {
        this.viewModel = viewModel;
        this.context = context;
        this.constructorMascotas = new ConstructorPet(context);

        this.viewModel.prepareToolbar();
        obtenerFavoritos();
    }

    @Override
    public void obtenerFavoritos() {
        List<Pet> mascotas = constructorMascotas.obtenerDatos();
        viewModel.prepareRecyclerView(mascotas);
    }
}