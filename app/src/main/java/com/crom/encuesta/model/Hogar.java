package com.crom.encuesta.model;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> toList() {
        ArrayList<String> strings = new ArrayList<String>();
        for (String servicio : serviciosBienes) {
            StringBuilder output = new StringBuilder();
            output.append(miembros.size());
            output.append(",");
            output.append(servicio);
            output.append(",");
            output.append(aguaConsumo);
            output.append(",");
            output.append(aguaOtroUso);
            output.append(",");
            output.append(basura);
            output.append(",");
            output.append(sanitarioHogar);
            output.append(",");
            output.append(sanitarioVivienda);
            output.append(",");
            output.append(energiaCocinan);
            output.append(",");
            for (Miembro miembro : miembros) {
                StringBuilder output2 = new StringBuilder();
                output2.append(output);
                output2.append(miembro);
                strings.add(output2.toString());
            }
        }
        return strings;
    }
}
