package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.FuerzaTrabajo;
import com.crom.encuesta.model.Ocupado;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 8/07/16.
 */
public class FuerzaTrabajoDAO implements DAO<FuerzaTrabajo, String> {
    private static FuerzaTrabajoDAO ourInstance = new FuerzaTrabajoDAO();
    private static int SIZE = 0;
    private static String TABLE_FUERZA_TRABAJO ="fuerzaTrabajo";
    private static String fuerzaTrabajoId = "fuerzaTrabajoId";
    private static String miembroId = "miembroId";
    private static String d1="d1", d2="d2", d3="d3", d4="d4", d5="d5", d6="d6", d7="d7", d8="d8",
            d9="d9", d10="d10", d11="d11", d12="d12", d13="d13";


    public static FuerzaTrabajoDAO getInstance() {
        return ourInstance;
    }

    private FuerzaTrabajoDAO() {
    }

    @Override
    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_FUERZA_TRABAJO + " ( " +
                fuerzaTrabajoId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                miembroId + " TEXT, "+
                d1 + " TEXT, " +
                d2 + " TEXT, " +
                d3 + " TEXT, " +
                d4 + " TEXT, " +
                d5 + " TEXT, " +
                d6 + " TEXT, " +
                d7 + " TEXT, " +
                d8 + " TEXT, " +
                d9 + " TEXT, " +
                d10 + " TEXT, " +
                d11+ " TEXT, " +
                d12 + " TEXT, " +
                d13 + " TEXT " +
                " )";
        db.execSQL(query);
    }

    @Override
    public FuerzaTrabajo insert(FuerzaTrabajo fuerzaTrabajo, SQLiteDatabase db) {
        SIZE = ((ArrayList) read(db)).size();
        ContentValues values = new ContentValues();
        values.put(fuerzaTrabajoId, SIZE+1);
        values.put(miembroId, fuerzaTrabajo.getMiembroId());
        values.put(d1,fuerzaTrabajo.getD1());
        values.put(d2,fuerzaTrabajo.getD2());
        values.put(d3,fuerzaTrabajo.getD3());
        values.put(d4,fuerzaTrabajo.getD4());
        values.put(d5,fuerzaTrabajo.getD5());
        values.put(d6,fuerzaTrabajo.getD6());
        values.put(d7,fuerzaTrabajo.getD7());
        values.put(d8,fuerzaTrabajo.getD8());
        values.put(d9,fuerzaTrabajo.getD9());
        values.put(d10,fuerzaTrabajo.getD10());
        values.put(d11,fuerzaTrabajo.getD11());
        values.put(d12,fuerzaTrabajo.getD12());
        values.put(d13,fuerzaTrabajo.getD13());
        Log.i("FuerzaTrabajoDAO", "Nuevo registro FuerzaTrabajo" );
        if((db.insert( TABLE_FUERZA_TRABAJO , null, values ) != -1)){

        }else return null;
        return fuerzaTrabajo;
    }

    @Override
    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FUERZA_TRABAJO);
    }

    @Override
    public List<FuerzaTrabajo> read(SQLiteDatabase db) {
        Cursor c = db.query(TABLE_FUERZA_TRABAJO, null, null, null, null, null, null);
        ArrayList<FuerzaTrabajo> fuerzaTrabajos = new ArrayList<>();
        //String[] args = new String[] {"Prueba"};
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                FuerzaTrabajo fuerzaTrabajo = new FuerzaTrabajo(c.getString(0), c.getString(1),
                        c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),
                        c.getString(7),c.getString(8),c.getString(9),c.getString(10),c.getString(11),
                        c.getString(12),c.getString(13),c.getString(14));
                Log.i("#######", fuerzaTrabajo.toString());
                fuerzaTrabajos.add(fuerzaTrabajo);
            }while (c.moveToNext());
        }
        return fuerzaTrabajos;
    }

    @Override
    public FuerzaTrabajo read(SQLiteDatabase db, String id) {
        return null;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, FuerzaTrabajo fuerzaTrabajo) {
        return false;
    }
}
