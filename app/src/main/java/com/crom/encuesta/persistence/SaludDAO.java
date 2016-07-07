package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.model.Salud;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 7/07/16.
 */
public class SaludDAO implements DAO<Salud, String>{
    private static SaludDAO ourInstance = new SaludDAO();
    private static String TABLE_SALUD = "salud";
    private static String saludId = "saludId" ;
    private static String miembroId = "miembroId";
    private static String afiliado= "afiliado";
    private static String regimenAfiliado= "regimenAfiliado";
    private static String atencionESE= "atencionESE";
    private static String comentarioAtencionESE= "comentarioAtencionESE";
    private static int SIZE = 0;

    public static SaludDAO getInstance() {
        return ourInstance;
    }

    private SaludDAO() {
    }

    @Override
    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_SALUD + " ( " +
                saludId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                miembroId + " TEXT, " +
                afiliado + " TEXT, " +
                regimenAfiliado + " TEXT, " +
                atencionESE + " TEXT, " +
                comentarioAtencionESE + " TEXT " +
                " )";
        db.execSQL(query);
    }

    @Override
    public Salud insert(Salud salud, SQLiteDatabase db) {
        SIZE = ((ArrayList) read(db)).size();
        ContentValues values = new ContentValues();
        values.put(saludId, SIZE+1);
        values.put(miembroId, salud.getMiembroId());
        values.put(afiliado,salud.getAfiliado());
        values.put(regimenAfiliado,salud.getRegimenAfiliado());
        values.put(atencionESE,salud.getAtencionESE());
        values.put(comentarioAtencionESE,salud.getComentarioAtencionESE());
        Log.i("SaludDAO", "Nuevo registro Salud" );
        if((db.insert( TABLE_SALUD , null, values ) != -1)){

        }else return null;
        salud.setId((SIZE+1)+"");
        return salud;
    }

    @Override
    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SALUD);
    }

    @Override
    public List<Salud> read(SQLiteDatabase db) {
        Cursor c = db.query(TABLE_SALUD, null, null, null, null, null, null);
        ArrayList<Salud> saluds = new ArrayList<>();
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                Salud salud = new Salud(c.getString(0),c.getString(1),c.getString(2),c.getString(3),
                        c.getString(4),c.getString(5));
                saluds.add(salud);
            }while (c.moveToNext());
        }
        return saluds;
    }

    @Override
    public Salud read(SQLiteDatabase db, String id) {
        return null;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, Salud salud) {
        return false;
    }
}
