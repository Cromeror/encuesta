/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crom.encuesta.model;

import java.util.ArrayList;

/**
 * @author cristobal
 */
public class Desocupado {

    private String id, miembroId;
    private String f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f13;
    private ArrayList<String> f12;

    public Desocupado() {
        id = "";
        miembroId = "";
        f1 = "";
        f2 = "";
        f3 = "";
        f4 = "";
        f5 = "";
        f6 = "";
        f7 = "";
        f8 = "";
        f9 = "";
        f10 = "";
        f11 = "";
        f12 = new ArrayList<>();
        f13 = "";
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

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    public String getF5() {
        return f5;
    }

    public void setF5(String f5) {
        this.f5 = f5;
    }

    public String getF6() {
        return f6;
    }

    public void setF6(String f6) {
        this.f6 = f6;
    }

    public String getF7() {
        return f7;
    }

    public void setF7(String f7) {
        this.f7 = f7;
    }

    public String getF8() {
        return f8;
    }

    public void setF8(String f8) {
        this.f8 = f8;
    }

    public String getF9() {
        return f9;
    }

    public void setF9(String f9) {
        this.f9 = f9;
    }

    public String getF10() {
        return f10;
    }

    public void setF10(String f10) {
        this.f10 = f10;
    }

    public String getF11() {
        return f11;
    }

    public void setF11(String f11) {
        this.f11 = f11;
    }

    public ArrayList<String> getF12() {
        return f12;
    }

    public void setF12(ArrayList<String> f12) {
        this.f12 = f12;
    }

    public String getF13() {
        return f13;
    }

    public void setF13(String f13) {
        this.f13 = f13;
    }

    @Override
    public String toString() {
        return "Desocupado{" +
                "id='" + id + '\'' +
                ", miembroId='" + miembroId + '\'' +
                ", f1='" + f1 + '\'' +
                ", f2='" + f2 + '\'' +
                ", f3='" + f3 + '\'' +
                ", f4='" + f4 + '\'' +
                ", f5='" + f5 + '\'' +
                ", f6='" + f6 + '\'' +
                ", f7='" + f7 + '\'' +
                ", f8='" + f8 + '\'' +
                ", f9='" + f9 + '\'' +
                ", f10='" + f10 + '\'' +
                ", f11='" + f11 + '\'' +
                ", f12='" + f12 + '\'' +
                ", f13='" + f13 + '\'' +
                '}';
    }
}
