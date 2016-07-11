package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Vivienda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 11/07/16.
 */
public class SuperDAO {
    public static int SIZE = 0;
    private static SuperDAO ourInstance = new SuperDAO();
    private static String TABLE_VIVIENDA = "super";
    private static String viviendaId = "viviendaId";
    private static String data = "data";

    public static SuperDAO getInstance() {
        return ourInstance;
    }

    private SuperDAO() {
    }


    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_VIVIENDA + " ( " +
                viviendaId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                data + " TEXT) ";
        db.execSQL(query);
    }

    public Vivienda insert(Vivienda vivienda, SQLiteDatabase db) {
        SIZE = ((ArrayList) read(db)).size();
        ContentValues values = new ContentValues();
        values.put(viviendaId, SIZE+1);
        values.put(data,vivienda.toString());
        if(db.insert( TABLE_VIVIENDA , null, values ) != -1){
            Log.i("ViviendaDAO", "Nuevo registro Vivienda" );
        }else return null;
        vivienda.setId((SIZE+1)+"");
        return vivienda;
    }

    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIVIENDA);
    }

    public List<String> read(SQLiteDatabase db) {
        Cursor c = db.query(TABLE_VIVIENDA, null, null, null, null, null, null);
        ArrayList<String> viviendas = new ArrayList<>();
        //String[] args = new String[] {"Prueba"};
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                viviendas.add(c.getString(1));
            }while (c.moveToNext());
        }
        return viviendas;

    }
}
