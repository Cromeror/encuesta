package com.crom.encuesta.model;

/**
 * Created by Katherine Buelvas on 19/06/2016.
 */
public class Salud {
    private String afiliado, regimenAfiliado, atencionESE, comentarioAtencionESE;

    public Salud() {
        afiliado = "";
        regimenAfiliado = "";
        atencionESE = "";
        comentarioAtencionESE = "";
    }

    public String getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(String afiliado) {
        this.afiliado = afiliado;
    }

    public String getRegimenAfiliado() {
        return regimenAfiliado;
    }

    public void setRegimenAfiliado(String regimenAfiliado) {
        this.regimenAfiliado = regimenAfiliado;
    }

    public String getAtencionESE() {
        return atencionESE;
    }

    public void setAtencionESE(String atencionESE) {
        this.atencionESE = atencionESE;
    }

    public String getComentarioAtencionESE() {
        return comentarioAtencionESE;
    }

    public void setComentarioAtencionESE(String comentarioAtencionESE) {
        this.comentarioAtencionESE = comentarioAtencionESE;
    }

    @Override
    public String toString() {
        return afiliado + ',' + regimenAfiliado + ',' + atencionESE + ',' + comentarioAtencionESE;
    }
}
