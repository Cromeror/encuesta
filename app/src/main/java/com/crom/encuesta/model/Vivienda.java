package com.crom.encuesta.model;

import java.util.ArrayList;

/**
 * Created by Katherine Buelvas on 17/06/2016.
 */
public class Vivienda {

    private String id;
    private String departamento;
    private String municipio;
    private String zona;
    private String barrio;
    private String sector;
    private String direccion;
    private String tipoVivienda;
    private String propiedadVivienda;
    private String cuantoPagan;
    private String materialPisos;
    private String materialParedesExteriores;
    private ArrayList<String> cuartos;
    private ArrayList<String> servicios;
    private ArrayList<Hogar> hogares;

    public Vivienda(String id, String departamento, String municipio, String zona, String barrio,
                    String sector, String direccion, String tipoVivienda, String propiedadVivienda,
                    String cuantoPagan, String materialPisos, String materialParedesExteriores,
                    ArrayList<String> cuartos, ArrayList<String> servicios, ArrayList<Hogar> hogares) {
        this.id = id;
        this.departamento = departamento;
        this.municipio = municipio;
        this.zona = zona;
        this.barrio = barrio;
        this.sector = sector;
        this.direccion = direccion;
        this.tipoVivienda = tipoVivienda;
        this.propiedadVivienda = propiedadVivienda;
        this.cuantoPagan = cuantoPagan;
        this.materialPisos = materialPisos;
        this.materialParedesExteriores = materialParedesExteriores;
        this.cuartos = cuartos;
        this.servicios = servicios;
        this.hogares = hogares;
    }

    public Vivienda() {
        /*departamento = "";
        municipio = "";
        zona = "";
        barrio = "";
        sector = "";
        direccion = "";
        tipoVivienda = "";
        propiedadVivienda = "";
        cuantoPagan = "";
        materialPisos = "";
        materialParedesExteriores = "";*/
        cuartos = new ArrayList<>();
        servicios = new ArrayList<>();
        hogares = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Hogar getLastHogar() {
        if (hogares.size() > 0) {
            return hogares.get(hogares.size() - 1);
        }
        return null;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        StringBuilder result = new StringBuilder();
        output.append(depurarComas(id));
        output.append(",");
        output.append(depurarComas(departamento));
        output.append(",");
        output.append(depurarComas(municipio));
        output.append(",");
        output.append(depurarComas(zona));
        output.append(",");
        output.append(depurarComas(barrio));
        output.append(",");
        output.append(depurarComas(sector));
        output.append(",");
        output.append(depurarComas(direccion));
        output.append(",");
        output.append(depurarComas(tipoVivienda));
        output.append(",");
        output.append(depurarComas(propiedadVivienda));
        output.append(",");
        output.append(depurarComas(cuantoPagan));
        output.append(",");
        output.append(cuartos.size());
        output.append(",");
//                System.err.println("asdasdsa: "+cuartos.size());
        for (String personasCuarto : cuartos) {
            StringBuilder output2 = new StringBuilder();
            output2.append(output);
            output2.append(personasCuarto);
            output2.append(",");
            output2.append(depurarComas(materialPisos));
            output2.append(",");
            output2.append(depurarComas(materialParedesExteriores));
            output2.append(",");
            for (String servicio : servicios) {
                StringBuilder output3 = new StringBuilder();
                output3.append(output2);
                output3.append(servicio);
                output3.append(",");
                output3.append(hogares.size());
                output3.append(",");
                for (Hogar hogar : hogares) {
                    for (String string : hogar.toList()) {
                        StringBuilder output4 = new StringBuilder();
                        output4.append(output3);
                        output4.append(string);
                        output4.append("\n");
                        result.append(output4);
                    }
                }
                //output3.append("\n");
                //result.append(output3);
            }

        }
        return result.toString();
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
