package com.crom.encuesta.model;

/**
 * Created by Katherine Buelvas on 17/06/2016.
 */
public class Miembro {
    private String sexo, nacimiento, edad, lugarNacimiento, parentesco, estadoCivil;
    private Salud salud;

    public Miembro() {
        sexo = "";
        nacimiento = "";
        edad = "";
        lugarNacimiento = "";
        parentesco = "";
        estadoCivil = "";
        salud = new Salud();
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Salud getSalud() {
        return salud;
    }

    public void setSalud(Salud salud) {
        this.salud = salud;
    }

    @Override
    public String toString() {
        return sexo + ',' + nacimiento + ',' + edad + ',' + lugarNacimiento + ',' + parentesco + ',' + estadoCivil + ',' + salud;
    }
}
