package com.crom.encuesta.model;

import java.util.ArrayList;

/**
 * Created by Katherine Buelvas on 17/06/2016.
 */
public class Hogar {
    private ArrayList<Miembro> miembros;

    @Override
    public String toString() {
        return "Hogar{" +
                "miembros=" + miembros +
                '}';
    }
}
