package com.crom.encuesta.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Hogar;
import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.model.Ocupado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cristobal on 8/07/16.
 */
public class OcupadoDAO implements DAO<Ocupado, String> {
    private static OcupadoDAO ourInstance = new OcupadoDAO();
    private static String TABLE_OCUPADO = "ocupado";
    private static String TABLE_E11 = "ocupado11";
    private static String TABLE_E55 = "ocupado55";
    private static String[] camposE;
    private static String ocupadoId = "ocupadoId";
    private static String miembroId = "miembroId";
    private static String e11Id = "e11Id";
    private static String e55Id = "e55Id";
    private static String valueE11 = "valueE11";
    private static String valueE55 = "valueE55";

    public static OcupadoDAO getInstance() {
        return ourInstance;
    }

    private OcupadoDAO() {
        camposE = new String[60];
        int value = 1;
        for (int i = 0; i < camposE.length; i++) {
            if (i == 11)
                value++;
            if (i == 54)
                value++;
            if (i == 7) {
                value--;
                camposE[i] = "e" + value + "a";
            } else
                camposE[i] = "e" + value;
            value++;
        }
    }

    @Override
    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_OCUPADO + " ( " +
                ocupadoId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                miembroId + " TEXT, ";
        for (String c : camposE) {
            query += c + " TEXT, ";
        }
        query +=e11Id + " TEXT, " +
                        e55Id + " TEXT " +
                        " )";
        db.execSQL(query);
        Log.i("TABA Hogare", query);
        query = "CREATE TABLE " + TABLE_E11 + " ( " +
                e11Id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                ocupadoId + " TEXT, "+
                valueE11 + " TEXT" +
                ")";
        db.execSQL(query);
        Log.i("TABA Hogare", query);
        query = "CREATE TABLE " + TABLE_E55 + " ( " +
                e55Id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                ocupadoId + " TEXT, "+
                valueE55 + " TEXT" +
                ")";
        db.execSQL(query);
        Log.i("TABA Hogare", query);
    }

    @Override
    public Ocupado insert(Ocupado ocupado, SQLiteDatabase db) {
        return null;
    }

    @Override
    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OCUPADO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_E11);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_E55);
    }

    @Override
    public List<Ocupado> read(SQLiteDatabase db) {
        Cursor c = db.query(TABLE_OCUPADO, null, null, null, null, null, null);
        ArrayList<Ocupado> ocupados = new ArrayList<>();
        //String[] args = new String[] {"Prueba"};
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                Ocupado ocupado = new Ocupado();
                ocupado.setId(c.getString(0));
                ocupado.setMiembroId(c.getString(1));
                ocupados.add(ocupado);
                Log.i("#######", ocupado.toString());
            }while (c.moveToNext());
        }
        return ocupados;
    }

    @Override
    public Ocupado read(SQLiteDatabase db, String id) {
        return null;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, Ocupado ocupado) {
        return false;
    }
}
