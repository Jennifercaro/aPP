package com.daveco.thewalkingdog.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    private static final int NUMBER_OF_FAVORITES = 5;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASET_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaFavoritos = "CREATE TABLE " + ConstantesBaseDatos.TABLE_FAVORITOS + "("
                + ConstantesBaseDatos.TABLE_FAVORITOS_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBaseDatos.TABLE_FAVORITOS_ID_MASCOTA    + " INTEGER, "
                + ConstantesBaseDatos.TABLE_FAVORITOS_NOMBRE        + " TEXT, "
                + ConstantesBaseDatos.TABLE_FAVORITOS_FOTO          + " INTEGER, "
                + ConstantesBaseDatos.TABLE_FAVORITOS_LIKES         + " INTEGER"
                + ")";

        db.execSQL(queryCrearTablaFavoritos);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_FAVORITOS);
        onCreate(db);
    }

    public List<Pet> obtenerFavoritos() {
        List<Pet> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_FAVORITOS + " ORDER BY " + ConstantesBaseDatos.TABLE_FAVORITOS_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while(registros.moveToNext()) {
            Pet mascota = new Pet();
            mascota.setId(registros.getInt(1));
            mascota.setName(registros.getString(2));
            mascota.setPicture(registros.getInt(3));
            mascota.setLikes(registros.getInt(4));
            mascotas.add(mascota);
        }
        db.close();
        return mascotas;
    }

    public void insertarLike(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();

        // eliminamos el primer like si ya tenemos 5
        String deleteQuery = "DELETE FROM " + ConstantesBaseDatos.TABLE_FAVORITOS
                + " WHERE " + NUMBER_OF_FAVORITES + "<="
                + "(SELECT COUNT(" + ConstantesBaseDatos.TABLE_FAVORITOS_ID + ") FROM " + ConstantesBaseDatos.TABLE_FAVORITOS + ")"
                + " AND " + ConstantesBaseDatos.TABLE_FAVORITOS_ID + "="
                + "(SELECT MIN(" + ConstantesBaseDatos.TABLE_FAVORITOS_ID + ") FROM " + ConstantesBaseDatos.TABLE_FAVORITOS + ")";
        db.execSQL(deleteQuery);

        // insertamos el nuevo like
        db.insert(ConstantesBaseDatos.TABLE_FAVORITOS, null, contentValues);
        db.close();
    }
}
}