package com.crom.encuesta.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristóbal Romero on 17/06/2016.
 */
public class Miembro {

    private String sexo, nacimiento, edad, lugarNacimiento, parentesco, estadoCivil;
    private Salud salud;
    private Educacion educacion;
    private FuerzaTrabajo fuerzaTrabajo;
    private Ocupado ocupado;//con lista
    private Desocupado desocupado;
    private Inactivo inactivo;
    private OtroIngreso otroIngreso;
    private TIC tic;//con lista

    public Miembro() {
        sexo = "";
        nacimiento = "";
        edad = "";
        lugarNacimiento = "";
        parentesco = "";
        estadoCivil = "";
        salud = new Salud();
        educacion = new Educacion();
        ocupado = new Ocupado();
        desocupado = new Desocupado();
        inactivo = new Inactivo();
        otroIngreso = new OtroIngreso();
        tic = new TIC();
    }

    public Desocupado getDesocupado() {
        return desocupado;
    }

    public void setDesocupado(Desocupado desocupado) {
        this.desocupado = desocupado;
    }

    public FuerzaTrabajo getFuerzaTrabajo() {
        return fuerzaTrabajo;
    }

    public void setFuerzaTrabajo(FuerzaTrabajo fuerzaTrabajo) {
        this.fuerzaTrabajo = fuerzaTrabajo;
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

    public Educacion getEducacion() {
        return educacion;
    }

    public void setEducacion(Educacion educacion) {
        this.educacion = educacion;
    }

    public Ocupado getOcupado() {
        return ocupado;
    }

    public void setOcupado(Ocupado ocupado) {
        this.ocupado = ocupado;
    }

    public Inactivo getInactivo() {
        return inactivo;
    }

    public void setInactivo(Inactivo inactivo) {
        this.inactivo = inactivo;
    }

    public OtroIngreso getOtroIngreso() {
        return otroIngreso;
    }

    public void setOtroIngreso(OtroIngreso otroIngreso) {
        this.otroIngreso = otroIngreso;
    }

    public TIC getTic() {
        return tic;
    }

    public void setTic(TIC tic) {
        this.tic = tic;
    }

    public List<String> toList() {
        ArrayList<String> list = new ArrayList<>();
        String s = sexo + ',' + nacimiento + ',' + edad + ',' + lugarNacimiento + ',' + parentesco + ','
                + estadoCivil + ',' + salud + "," + educacion + "," + fuerzaTrabajo + ",";

        for (String string : ocupado.toList()) {
            for (String string1 : tic.toList()) {
                String s2 = s + string + ',' + desocupado.toString() + "," 
                        + inactivo.toString() + "," + otroIngreso.toString() + ","+string1;
                list.add(s2);
            }
        }
        return list;
    }
}
