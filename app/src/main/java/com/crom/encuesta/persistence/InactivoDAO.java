package com.crom.encuesta.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Inactivo;
import com.crom.encuesta.model.Ocupado;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 11/07/16.
 */
public class InactivoDAO implements DAO<Inactivo, String> {
    private static InactivoDAO ourInstance = new InactivoDAO();
    private static String TABLE_INACTIVO = "inactivo";
    private static String[] camposG;
    private static String inactivoId = "inactivoId";
    private static String miembroId = "miembroId";

    public static InactivoDAO getInstance() {
        return ourInstance;
    }

    private InactivoDAO() {
        camposG = new String[10];
        int value = 1;
        for (int i = 0; i < camposG.length; i++) {
            camposG[i] = "g" + value;
            value++;
        }
    }

    @Override
    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_INACTIVO + " ( " +
                inactivoId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                miembroId + " TEXT, ";
        for (int i = 0; i < camposG.length; i++) {
            if (i == camposG.length - 1)
                query += " )";
            else
                query += camposG[i] + " TEXT, ";
        }
        db.execSQL(query);
        Log.i("QUERY INACTIVO", query);
    }

    @Override
    public Inactivo insert(Inactivo inactivo, SQLiteDatabase db) {
        return null;
    }

    @Override
    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INACTIVO);
    }

    @Override
    public List<Inactivo> read(SQLiteDatabase db) {
        Cursor c = db.query(TABLE_INACTIVO, null, null, null, null, null, null);
        ArrayList<Inactivo> inactivos = new ArrayList<>();
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                Inactivo inactivo = new Inactivo();
                inactivo.setId(c.getString(0));
                inactivo.setMiembroId(c.getString(1));
                inactivos.add(inactivo);
                Log.i("#######", inactivo.toString());
            }while (c.moveToNext());
        }
        return inactivos;
    }

    @Override
    public Inactivo read(SQLiteDatabase db, String id) {
        return null;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, Inactivo inactivo) {
        return false;
    }
}
