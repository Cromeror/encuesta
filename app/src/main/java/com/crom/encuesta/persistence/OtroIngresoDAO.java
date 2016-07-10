package com.crom.encuesta.persistence;

import android.database.sqlite.SQLiteDatabase;

import com.crom.encuesta.model.OtroIngreso;

import java.util.List;

/**
 * Created by cristobal on 8/07/16.
 */
public class OtroIngresoDAO implements DAO<OtroIngreso, String> {
    private static OtroIngresoDAO ourInstance = new OtroIngresoDAO();
    private final static String TABLE_OTRO = "otros_ingresos";
    private static String otroId = "otroId";
    private static String miembroId = "miembroId";
    private static String h1 = "h1";
    private static String h2a = "h2a";
    private static String h2b = "h2b";
    private static String h2c = "h2c";

    public static OtroIngresoDAO getInstance() {
        return ourInstance;
    }

    private OtroIngresoDAO() {
    }

    @Override
    public void create(SQLiteDatabase db) {

    }

    @Override
    public OtroIngreso insert(OtroIngreso otroIngreso, SQLiteDatabase db) {
        return null;
    }

    @Override
    public void drop(SQLiteDatabase db) {

    }

    @Override
    public List<OtroIngreso> read(SQLiteDatabase db) {
        return null;
    }

    @Override
    public OtroIngreso read(SQLiteDatabase db, String id) {
        return null;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, OtroIngreso otroIngreso) {
        return false;
    }
}
