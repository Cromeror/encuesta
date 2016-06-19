package com.crom.encuesta.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Katherine Buelvas on 17/06/2016.
 */
public class Vivienda {
    private String departamento;
    private String municipio;
    private String zona;
    private String barrio;
    private String sector;
    private String direccion;
    private String tipoVivienda;
    private String propiedadVivienda;
    private String cuantoPagan;
    private ArrayList<String> cuartos;
    private String materialPisos;
    private String materialParedesExteriores;
    private ArrayList<String> servicios;
    private ArrayList<Hogar> hogares;

    public Vivienda() {
        departamento = "";
        municipio = "";
        zona = "";
        barrio = "";
        sector = "";
        direccion = "";
        tipoVivienda = "";
        propiedadVivienda = "";
        cuantoPagan = "";
        cuartos = new ArrayList<>();
        materialPisos = "";
        materialParedesExteriores = "";
        servicios = new ArrayList<>();
        hogares = new ArrayList<>();
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public String getPropiedadVivienda() {
        return propiedadVivienda;
    }

    public void setPropiedadVivienda(String propiedadVivienda) {
        this.propiedadVivienda = propiedadVivienda;
    }

    public String getCuantoPagan() {
        return cuantoPagan;
    }

    public void setCuantoPagan(String cuantoPagan) {
        this.cuantoPagan = cuantoPagan;
    }

    public ArrayList<String> getCuartos() {
        return cuartos;
    }

    public void setCuartos(ArrayList<String> cuartos) {
        this.cuartos = cuartos;
    }

    public String getMaterialPisos() {
        return materialPisos;
    }

    public void setMaterialPisos(String materialPisos) {
        this.materialPisos = materialPisos;
    }

    public String getMaterialParedesExteriores() {
        return materialParedesExteriores;
    }

    public void setMaterialParedesExteriores(String materialParedesExteriores) {
        this.materialParedesExteriores = materialParedesExteriores;
    }

    public ArrayList<String> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<Hogar> getHogares() {
        return hogares;
    }

    public void setHogares(ArrayList<Hogar> hogares) {
        this.hogares = hogares;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        StringBuilder result = new StringBuilder();
        output.append(departamento);
        output.append(",");
        output.append(municipio);
        output.append(",");
        output.append(zona);
        output.append(",");
        output.append(barrio);
        output.append(",");
        output.append(sector);
        output.append(",");
        output.append(direccion);
        output.append(",");
        output.append(tipoVivienda);
        output.append(",");
        output.append(propiedadVivienda);
        output.append(",");
        output.append(cuantoPagan);
        output.append(",");
        output.append(cuartos.size());
        output.append(",");
        for (String personasCuarto : cuartos) {
            StringBuilder output2 = new StringBuilder();
            Log.i("PERSONAS POR CUARTO", personasCuarto);
            output2.append(output);
            output2.append(personasCuarto);
            output2.append(",");
            output2.append(materialPisos);
            output2.append(",");
            output2.append(materialParedesExteriores);
            output2.append(",");
            for (String servicio : servicios) {
                StringBuilder output3 = new StringBuilder();
                output3.append(output2);
                output3.append(servicio);
                output3.append(",");
                output3.append(hogares.size());
                output3.append("\n");
                result.append(output3);
            }
        }
        return result.toString();
    }
}
