package com.daveco.thewalkingdog.pojo;

public class Mascota {

    private int foto_perro;
    private String nombre_mascota;
    private int num_likes;

    public Mascota(int foto_perro, String nombre_mascota, int num_likes){
        this.foto_perro = foto_perro;
        this.nombre_mascota = nombre_mascota;
        this.num_likes = num_likes;
    }

    public int getFoto_perro() {
        return foto_perro;
    }

    public void setFoto_perro(int foto_perro) {
        this.foto_perro = foto_perro;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public int getNum_likes() {
        return num_likes;
    }

    public void setNum_likes(int num_likes) {
        this.num_likes = num_likes;
    }

    public void like (){
        this.num_likes += 1;
    }

}
