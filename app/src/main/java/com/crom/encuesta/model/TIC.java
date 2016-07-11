/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crom.encuesta.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cristobal
 */
public class TIC {

    private String id, miembroId, i1, i2, i5;
    private ArrayList<String> i3, i4;

    public TIC() {
        i3 = new ArrayList<String>();
        i4 = new ArrayList<String>();
    }

    public TIC(String id, String miembroId, String i1, String i2, String i5, ArrayList<String> i3, ArrayList<String> i4) {
        this.id = id;
        this.miembroId = miembroId;
        this.i1 = i1;
        this.i2 = i2;
        this.i5 = i5;
        this.i3 = i3;
        this.i4 = i4;
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

    public String getI1() {
        return i1;
    }

    public void setI1(String i1) {
        this.i1 = i1;
    }

    public String getI2() {
        return i2;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }

    public String getI5() {
        return i5;
    }

    public void setI5(String i5) {
        this.i5 = i5;
    }

    public ArrayList<String> getI3() {
        return i3;
    }

    public void setI3(ArrayList<String> i3) {
        this.i3 = i3;
    }

    public ArrayList<String> getI4() {
        return i4;
    }

    public void setI4(ArrayList<String> i4) {
        this.i4 = i4;
    }

    public List<String> toList() {
        StringBuilder output = new StringBuilder();
        ArrayList<String> strings = new ArrayList<String>();
        output.append(i1 + "," + i2 + ",");
        for (String stringI3 : i3) {
            StringBuilder output2 = new StringBuilder();
            output2.append(output);
            output2.append(stringI3);
            output2.append(",");
            for (String stringI4 : i4) {
                StringBuilder output3 = new StringBuilder();
                output3.append(output2);
                output3.append(stringI4);
                output3.append(",");
                output3.append(i5);
                strings.add(output3.toString());
            }
        }
        return strings;
    }

    @Override
    public String toString() {
        return i1 + ',' +
                i2 + ',' +
                "null," +
                "null," +
                i5;
    }
}
