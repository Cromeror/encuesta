package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.model.Vivienda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 6/07/16.
 */
public class MiembroDAO implements DAO<Miembro, String> {
    private static int SIZE = 0;
    private static String TABLE_MIEMBRO = "miembro";
    private String miembroId = "miembroId";
    private String sexo = "sexo";
    private String nacimiento = "nacimiento";
    private String edad = "edad";
    private String lugarNacimiento = "lugarNacimiento";
    private String parentesco = "parentesco";
    private String estadoCivil = "estadoCivil";
    private String hogarId = "hogarId";

   /* private Salud salud;
    private Educacion educacion;
    private FuerzaTrabajo fuerzaTrabajo;
    private Ocupado ocupado;//con lista
    private Desocupado desocupado;
    private Inactivo inactivo;
    private OtroIngreso otroIngreso;
    private TIC tic;*/

    private static MiembroDAO ourInstance = new MiembroDAO();

    public static MiembroDAO getInstance() {
        return ourInstance;
    }

    private MiembroDAO() {
    }


    @Override
    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_MIEMBRO + " ( " +
                miembroId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                sexo + " TEXT, " +
                nacimiento + " TEXT, " +
                edad + " TEXT, " +
                lugarNacimiento + " TEXT, " +
                parentesco + " TEXT, " +
                estadoCivil + " TEXT, " +
                hogarId +" TEXT"+
                " )";
        db.execSQL(query);
    }

    @Override
    public Miembro insert(Miembro miembro, SQLiteDatabase db) {
        drop(db);
        create(db);
        SIZE = ((ArrayList) read(db)).size();
        ContentValues values = new ContentValues();
        values.put(miembroId, SIZE+1);
        values.put(hogarId, miembro.getHogarId());
        values.put(sexo,miembro.getSexo());
        values.put(nacimiento,miembro.getNacimiento());
        values.put(edad,miembro.getEdad());
        values.put(lugarNacimiento,miembro.getLugarNacimiento());
        values.put(parentesco, miembro.getParentesco());
        values.put(estadoCivil, miembro.getEstadoCivil());
        Log.i("MiembroDAO", "Nuevo registro Miembro" );
        if((db.insert( TABLE_MIEMBRO , null, values ) != -1)){

        }else return null;
        return miembro;
    }

    @Override
    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MIEMBRO);
    }

    @Override
    public List<Miembro> read(SQLiteDatabase db) {
        String[] campos = new String[] {miembroId,hogarId, sexo, nacimiento,edad,lugarNacimiento, parentesco,
        estadoCivil};
        Cursor c = db.query(TABLE_MIEMBRO, null, null, null, null, null, null);
        ArrayList<Miembro> miembros = new ArrayList<>();
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                Miembro miembro = new Miembro(c.getString(0),c.getString(1),c.getString(2),c.getString(3),
                        c.getString(4),c.getString(5),c.getString(6),c.getString(7),null,null,null,null,null,null,null,null);
                miembros.add(miembro);
            }while (c.moveToNext());
        }
        return miembros;
    }

    @Override
    public Miembro read(SQLiteDatabase db, String id) {
        return null;
    }

    public List<Miembro> likeId(SQLiteDatabase db,String hogarId){
        ArrayList<Miembro> list = new ArrayList<>();
        String[] campos = new String[] {miembroId,hogarId, sexo, nacimiento,edad,lugarNacimiento, parentesco,
                estadoCivil};
        String[] args = {hogarId};
        Cursor c = db.query(TABLE_MIEMBRO, campos, hogarId+"=?", args, null, null, null);
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                list.add(new Miembro(c.getString(0),c.getString(1),c.getString(2),c.getString(3),
                        c.getString(4),c.getString(5),c.getString(6),c.getString(7),null,null,null,
                        null,null,null,null,null));
                Log.i(this.getClass()+" Miembro", c.getString(0));
            } while (c.moveToNext());
        }
        return list;
    }


    @Override
    public boolean update(SQLiteDatabase db, String id, Miembro miembro) {
        return false;
    }
}
