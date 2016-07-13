/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crom.encuesta.model;

/**
 *
 * @author Cristóbal Romero
 */
public class Educacion {

    private String id, miembroId, leerEscribir, asisteEscuela, establecimientoOficial, nivelEducativo, mayorTitulo;

    public Educacion(String id, String miembroId, String leerEscribir, String asisteEscuela, String establecimientoOficial, String nivelEducativo, String mayorTitulo) {
        this.id = id;
        this.miembroId = miembroId;
        this.leerEscribir = leerEscribir;
        this.asisteEscuela = asisteEscuela;
        this.establecimientoOficial = establecimientoOficial;
        this.nivelEducativo = nivelEducativo;
        this.mayorTitulo = mayorTitulo;
    }

    public Educacion() {
       /* leerEscribir = "";
        asisteEscuela = "";
        establecimientoOficial = "";
        nivelEducativo = "";
        mayorTitulo = "";
        id = "";
        miembroId = "";*/
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
        return depurarComas(leerEscribir+"") + ',' +
               depurarComas(asisteEscuela+"") + ',' +
               depurarComas(establecimientoOficial+"") + ',' +
               depurarComas(nivelEducativo+"") + ',' +
               depurarComas(mayorTitulo+"");
    }

    private String depurarComas(String cadena) {
        String result = "";
        if (cadena != null) {
            for (char c : cadena.toCharArray()) {
                if (c == ',')
                    c = '.';
                result += c;
            }
        } else
            result = cadena;
        return result;
    }
}
