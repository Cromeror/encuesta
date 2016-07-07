package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Educacion;
import com.crom.encuesta.model.Miembro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 7/07/16.
 */
public class EducacionDAO implements DAO<Educacion, String> {
    private static EducacionDAO ourInstance = new EducacionDAO();

    private static int SIZE = 0;
    private static String TABLE_EDUCACION = "miembro";
    private String educacionId = "educacionId";
    private String miembroId = "miembroId";
    private String leerEscribir = "leerEscribir";
    private String establecimientoOficial = "establecimientoOficial";
    private String nivelEducativo = "nivelEducativo";
    private String mayorTitulo = "mayorTitulo";

    public static EducacionDAO getInstance() {
        return ourInstance;
    }

    private EducacionDAO() {
    }

    @Override
    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_EDUCACION + " ( " +
                educacionId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                miembroId + " TEXT, " +
                leerEscribir + " TEXT, " +
                establecimientoOficial + " TEXT, " +
                nivelEducativo + " TEXT, " +
                mayorTitulo +" TEXT"+
                " )";
        db.execSQL(query);
    }

    @Override
    public Educacion insert(Educacion educacion, SQLiteDatabase db) {
        SIZE = ((ArrayList) read(db)).size();
        ContentValues values = new ContentValues();
        values.put(educacionId, SIZE+1);
        values.put(miembroId, educacion.getMiembroId());
        values.put(leerEscribir,educacion.getLeerEscribir());
        values.put(establecimientoOficial,educacion.getEstablecimientoOficial());
        values.put(nivelEducativo,educacion.getNivelEducativo());
        values.put(mayorTitulo,educacion.getMayorTitulo());
        Log.i("EducacionDAO", "Nuevo registro Educacion" );
        if((db.insert( TABLE_EDUCACION , null, values ) != -1)){

        }else return null;
        educacion.setId((SIZE+1)+"");
        return educacion;
    }

    @Override
    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EDUCACION);
    }

    @Override
    public List<Educacion> read(SQLiteDatabase db) {
        Cursor c = db.query(TABLE_EDUCACION, null, null, null, null, null, null);
        ArrayList<Educacion> educacions = new ArrayList<>();
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                Educacion educacion = new Educacion(c.getString(0),c.getString(1),c.getString(2),c.getString(3),
                        c.getString(4),c.getString(5),c.getString(6));
                educacions.add(educacion);
            }while (c.moveToNext());
        }
        return educacions;
    }

    @Override
    public Educacion read(SQLiteDatabase db, String id) {
        return null;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, Educacion educacion) {
        return false;
    }
}
