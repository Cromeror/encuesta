package com.crom.encuesta.model;

import java.util.ArrayList;

/**
 * Created by Katherine Buelvas on 17/06/2016.
 */
public class Hogar {
    private ArrayList<Miembro> miembros;
    private ArrayList<String> serviciosBienes;
    private String aguaConsumo, aguaOtroUso, basura, sanitarioHogar, sanitarioVivienda, energiaCocinan;

    public Hogar() {
        miembros = new ArrayList<>();
        serviciosBienes = new ArrayList<>();
        aguaConsumo = "";
        aguaOtroUso = "";
        basura = "";
        sanitarioHogar = "";
        sanitarioVivienda = "";
        energiaCocinan = "";
    }

    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(ArrayList<Miembro> miembros) {
        this.miembros = miembros;
    }

    public ArrayList<String> getServiciosBienes() {
        return serviciosBienes;
    }

    public void setServiciosBienes(ArrayList<String> serviciosBienes) {
        this.serviciosBienes = serviciosBienes;
    }

    public String getAguaConsumo() {
        return aguaConsumo;
    }

    public void setAguaConsumo(String aguaConsumo) {
        this.aguaConsumo = aguaConsumo;
    }

    public String getAguaOtroUso() {
        return aguaOtroUso;
    }

    public void setAguaOtroUso(String aguaOtroUso) {
        this.aguaOtroUso = aguaOtroUso;
    }

    public String getBasura() {
        return basura;
    }

    public void setBasura(String basura) {
        this.basura = basura;
    }

    public String getSanitarioHogar() {
        return sanitarioHogar;
    }

    public void setSanitarioHogar(String sanitarioHogar) {
        this.sanitarioHogar = sanitarioHogar;
    }

    public String getSanitarioVivienda() {
        return sanitarioVivienda;
    }

    public void setSanitarioVivienda(String sanitarioVivienda) {
        this.sanitarioVivienda = sanitarioVivienda;
    }

    public String getEnergiaCocinan() {
        return energiaCocinan;
    }

    public void setEnergiaCocinan(String energiaCocinan) {
        this.energiaCocinan = energiaCocinan;
    }

    @Override
    public String toString() {
        return "Hogar{" +
                "miembros=" + miembros +
                '}';
    }
}
