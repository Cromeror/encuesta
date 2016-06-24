/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crom.encuesta.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristobal
 */
public class Ocupado {

    private String e[];
    private ArrayList<String> e11, e55;

    public Ocupado() {
        e = new String[62];
        for (int i = 0; i < e.length; i++) {
            e[i] = "";
        }
        e11 = new ArrayList<>();
        e55 = new ArrayList<>();
    }

    /**
     *
     * @param number numero de pregunta que desea
     * @return
     */
    public String getE(int number) {
        return e[number];
    }

    public void setE(String answer, int number) {
        this.e[number] = answer;
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

    private String toString(String... values) {

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
    }

}
