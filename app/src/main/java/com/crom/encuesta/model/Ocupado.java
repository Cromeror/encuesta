/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crom.encuesta.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cristobal
 */
public class Ocupado {

    private String e[];
    private ArrayList<String> e11, e55;
    private String id, miembroId;
    
    public Ocupado() {
        id = "";
        miembroId = "";
        e = new String[62];
        for (int i = 0; i < e.length; i++) {
            e[i] = "";
        }
        e11 = new ArrayList<>();
        e55 = new ArrayList<>();
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

    /**
     *
     * @param number numero de pregunta que desea
     * @return
     */
    public String getE(int number) {
        if(number!=0&&number!=11&&number!=55){
            return this.e[number];
        }
        return  null;
    }

    public void setE(String answer, int number) {
        if(number!=0&&number!=11&&number!=55){
            this.e[number] = answer;
        }
    }

    public ArrayList<String> getE11() {
        return e11;
    }

    public void setE11(ArrayList<String> e11) {
        this.e11 = e11;
    }

    public ArrayList<String> getE55() {
        return e55;
    }

    public void setE55(ArrayList<String> e55) {
        this.e55 = e55;
    }

  /*  private String toString(String... values) {

        String string = "";
        e[11] = values[0];
        e[55] = values[1];
        for (int i = 0; i < e.length; i++) {
            if (i == e.length - 1) {
                string += e[i];
            } else {
                string += e[i] + ",";
            }
        }
        return string; //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        for (String string : e11) {
            for (String string1 : e55) {
//                String s = 
                list.add(toString(string, string1));
            }
        }
        return list;
    }*/

    @Override
    public String toString() {
        String s = "Ocupado{";
        for (int i = 0; i < e.length; i++) {
            if(i!=0){
                s+="e"+i+"="+e[i]+",";
            }
        }
        s+=", e11=" + e11 +
                ", e55=" + e55 +
                '}';
        return s;
    }
}
