package com.example.firmas;

import android.graphics.Bitmap;

public class Firmas {

    private String Descripcion;
    private byte[] firma;
    private Integer id;

    public Firmas() {

    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public byte[] getFirma() {
        return firma;
    }

    public void setFirma(byte[] firma) {
        this.firma = firma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
