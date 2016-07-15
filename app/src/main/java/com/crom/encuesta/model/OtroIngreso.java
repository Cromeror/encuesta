/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crom.encuesta.model;

/**
 * @author cristobal
 */
public class OtroIngreso {

    private String id, miembroId;
    private String[] f;

    public OtroIngreso() {
        f = new String[4];
        /*id = "";
        miembroId = "";
        for (int i = 0; i < f.length; i++) {
            f[i] = "";
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

    public String getH(int number) {
        return f[number];
    }

    public void setH(String answer, int number) {
        this.f[number] = answer;
    }

    @Override
    public String toString() {
        String string = "";
        string += "";
        for (int i = 0; i < f.length; i++) {
            if (i == f.length - 1) {
                string += f[i];
            } else {
                string += f[i] + ",";
            }
        }
        return string; //To change body of generated methods, choose Tools | Templates.
    }

}
