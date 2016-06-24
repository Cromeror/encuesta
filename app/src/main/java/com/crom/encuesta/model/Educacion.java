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
public class Educacion {

    private String leerEscribir, asisteEscuela, establecimientoOficial, nivelEducativo, mayorTitulo;

    public Educacion() {
        leerEscribir = "";
        asisteEscuela = "";
        establecimientoOficial = "";
        nivelEducativo = "";
        mayorTitulo = "";
    }

    public String getLeerEscribir() {
        return leerEscribir;
    }

    public void setLeerEscribir(String leerEscribir) {
        this.leerEscribir = leerEscribir;
    }

    public String getAsisteEscuela() {
        return asisteEscuela;
    }

    public void setAsisteEscuela(String asisteEscuela) {
        this.asisteEscuela = asisteEscuela;
    }

    public String getEstablecimientoOficial() {
        return establecimientoOficial;
    }

    public void setEstablecimientoOficial(String establecimientoOficial) {
        this.establecimientoOficial = establecimientoOficial;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public String getMayorTitulo() {
        return mayorTitulo;
    }

    public void setMayorTitulo(String mayorTitulo) {
        this.mayorTitulo = mayorTitulo;
    }

    @Override
    public String toString() {
        return leerEscribir + "," + asisteEscuela + "," + establecimientoOficial + "," + nivelEducativo + "," + mayorTitulo;
    }

}
