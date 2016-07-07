package com.crom.encuesta.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katherine Buelvas on 17/06/2016.
 */
public class Hogar {

    private String id, viviendaId;
    private ArrayList<Miembro> miembros;
    private ArrayList<String> serviciosBienes;
    private String aguaConsumo, aguaOtroUso, basura, sanitarioHogar, sanitarioVivienda, energiaCocinan;

    public Hogar(String id,String viviendaId, String aguaConsumo, String aguaOtroUso, String basura, String sanitarioHogar,
                 String sanitarioVivienda, String energiaCocinan,ArrayList<Miembro> miembros,
                 ArrayList<String> serviciosBienes) {
        this.miembros = miembros;
        this.viviendaId = viviendaId;
        this.serviciosBienes = serviciosBienes;
        this.aguaConsumo = aguaConsumo;
        this.aguaOtroUso = aguaOtroUso;
        this.basura = basura;
        this.sanitarioHogar = sanitarioHogar;
        this.sanitarioVivienda = sanitarioVivienda;
        this.energiaCocinan = energiaCocinan;
    }

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

    public String getViviendaId() {
        return viviendaId;
    }

    public void setViviendaId(String viviendaId) {
        this.viviendaId = viviendaId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Miembro getLastMiembro() {
        if (miembros.size() > 0) {
            return miembros.get(miembros.size() - 1);
        }
        return null;
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
                for (String string : miembro.toList()) {
                    StringBuilder output2 = new StringBuilder();
                    output2.append(output);
                    output2.append(string);
                    strings.add(output2.toString());
                }
            }
        }
        return strings;
    }

    @Override
    public String toString() {
        return "Hogar{" +
                "id='" + id + '\'' +
                ", viviendaId='" + viviendaId + '\'' +
                ", miembros=" + miembros +
                ", serviciosBienes=" + serviciosBienes +
                ", aguaConsumo='" + aguaConsumo + '\'' +
                ", aguaOtroUso='" + aguaOtroUso + '\'' +
                ", basura='" + basura + '\'' +
                ", sanitarioHogar='" + sanitarioHogar + '\'' +
                ", sanitarioVivienda='" + sanitarioVivienda + '\'' +
                ", energiaCocinan='" + energiaCocinan + '\'' +
                '}';
    }
}
