package com.crom.encuesta.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristóbal Romero on 17/06/2016.
 */
public class Miembro {

    private String id, hogarId, sexo, nacimiento, edad, lugarNacimiento, parentesco, estadoCivil;
    private Salud salud;
    private Educacion educacion;
    private FuerzaTrabajo fuerzaTrabajo;
    private Ocupado ocupado;//con lista
    private Desocupado desocupado;
    private Inactivo inactivo;
    private OtroIngreso otroIngreso;
    private TIC tic;//con lista

    public Miembro(String id, String hogarId, String sexo, String nacimiento, String edad, String lugarNacimiento, String parentesco, String estadoCivil, Salud salud, Educacion educacion, FuerzaTrabajo fuerzaTrabajo, Ocupado ocupado, Desocupado desocupado, Inactivo inactivo, OtroIngreso otroIngreso, TIC tic) {
        this.hogarId = hogarId;
        this.id = id;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.lugarNacimiento = lugarNacimiento;
        this.parentesco = parentesco;
        this.estadoCivil = estadoCivil;
        this.salud = salud;
        this.educacion = educacion;
        this.fuerzaTrabajo = fuerzaTrabajo;
        this.ocupado = ocupado;
        this.desocupado = desocupado;
        this.inactivo = inactivo;
        this.otroIngreso = otroIngreso;
        this.tic = tic;
    }

    public Miembro() {
        /*id = "";
        sexo = "";
        nacimiento = "";
        edad = "0";
        lugarNacimiento = "";
        parentesco = "";
        estadoCivil = "";*/
        salud = new Salud();
        educacion = new Educacion();
        ocupado = new Ocupado();
        desocupado = new Desocupado();
        inactivo = new Inactivo();
        otroIngreso = new OtroIngreso();
        tic = new TIC();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHogarId() {
        return hogarId;
    }

    public void setHogarId(String hogarId) {
        this.hogarId = hogarId;
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
        if (!ocupado.toList().isEmpty()) {
            for (String string : ocupado.toList()) {
                for (String string1 : tic.toList()) {
                    String s2 = s + string + ',' + desocupado.toList() + ","
                            + inactivo.toString() + "," + otroIngreso.toString() + "," + string1;
                    list.add(s2);
                }
            }
        } else {
            String string = (new Ocupado()).toString();

            Log.i("tic.toList()", "" + tic.toList().size());
            if (!tic.toList().isEmpty()) {
                for (String string1 : tic.toList()) {
                    String s2 = s + string + ',' + desocupado.toList() + ","
                            + inactivo.toString() + "," + otroIngreso.toString() + "," + string1;
                    list.add(s2);
                }
            } else {
                String s2 = s + string + ',' + desocupado.toList() + ","
                        + inactivo.toString() + "," + otroIngreso.toString() + "," + (new TIC()).toString();
                list.add(s2);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return sexo + "," +
                nacimiento + "," +
                edad + "," +
                lugarNacimiento + "," +
                parentesco + "," +
                estadoCivil + "," +
                salud + "," +
                educacion + "," +
                fuerzaTrabajo + "," +
                ocupado + "," +
                desocupado + "," +
                inactivo + "," +
                otroIngreso + "," +
                tic;
    }
}
