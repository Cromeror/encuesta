/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crom.encuesta.model;

/**
 * @author cristobal
 */
public class FuerzaTrabajo {

    private String id, miembroId, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13;

    public FuerzaTrabajo(String id, String miembroId, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String d9, String d10, String d11, String d12, String d13) {
        this.id = id;
        this.miembroId = miembroId;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
        this.d6 = d6;
        this.d7 = d7;
        this.d8 = d8;
        this.d9 = d9;
        this.d10 = d10;
        this.d11 = d11;
        this.d12 = d12;
        this.d13 = d13;
    }

    public FuerzaTrabajo() {
        /*id="";
        miembroId="";
        d1 = "";
        d2 = "";
        d3 = "";
        d4 = "";
        d5 = "";
        d6 = "";
        d7 = "";
        d8 = "";
        d9 = "";
        d10 = "";
        d11 = "";
        d12 = "";
        d13 = "";*/
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

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public String getD3() {
        return d3;
    }

    public void setD3(String d3) {
        this.d3 = d3;
    }

    public String getD4() {
        return d4;
    }

    public void setD4(String d4) {
        this.d4 = d4;
    }

    public String getD5() {
        return d5;
    }

    public void setD5(String d5) {
        this.d5 = d5;
    }

    public String getD6() {
        return d6;
    }

    public void setD6(String d6) {
        this.d6 = d6;
    }

    public String getD7() {
        return d7;
    }

    public void setD7(String d7) {
        this.d7 = d7;
    }

    public String getD8() {
        return d8;
    }

    public void setD8(String d8) {
        this.d8 = d8;
    }

    public String getD9() {
        return d9;
    }

    public void setD9(String d9) {
        this.d9 = d9;
    }

    public String getD10() {
        return d10;
    }

    public void setD10(String d10) {
        this.d10 = d10;
    }

    public String getD11() {
        return d11;
    }

    public void setD11(String d11) {
        this.d11 = d11;
    }

    public String getD12() {
        return d12;
    }

    public void setD12(String d12) {
        this.d12 = d12;
    }

    public String getD13() {
        return d13;
    }

    public void setD13(String d13) {
        this.d13 = d13;
    }

    @Override
    public String toString() {
        return d1 + ',' +
                d2 + ',' +
                d3 + ',' +
                d4 + ',' +
                d5 + ',' +
                d6 + ',' +
                d7 + ',' +
                d8 + ',' +
                d9 + ',' +
                d10 + ',' +
                d11 + ',' +
                d12 + ',' +
                d13;
    }
}
