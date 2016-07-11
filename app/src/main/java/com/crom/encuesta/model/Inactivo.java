/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crom.encuesta.model;

/**
 *
 * @author cristobal
 */
public class Inactivo {

    private String g[];
    private String id, miembroId;

    public Inactivo() {
        g = new String[10];
        /*id = "";
        miembroId = "";
        for (int i = 0; i < g.length; i++) {
            g[i] = "";
        }*/
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMiembroId() {
        return miembroId;
    }

    public void setMiembroId(String miembroId) {
        this.miembroId = miembroId;
    }

    public String getG(int number) {
        return g[number];
    }

    public void setG(String answer, int number) {
        this.g[number] = answer;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < g.length; i++) {
            if (i == g.length - 1) {
                string += g[i]+"";
            } else {
                string += g[i] + ",";
            }
        }
        return string; //To change body of generated methods, choose Tools | Templates.
    }

}
