package com.crom.encuesta.view_controller.custom;

/**
 * Created by Katherine Buelvas on 01/04/2016.
 */

public class IntegranteHogar {
    private String nombre;
    private int drawableImageID;

    public IntegranteHogar(String nombre, int drawableImageID) {
        this.nombre = nombre;
        this.drawableImageID = drawableImageID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDrawableImageID() {
        return drawableImageID;
    }

    public void setDrawableImageID(int drawableImageID) {
        this.drawableImageID = drawableImageID;
    }

}
