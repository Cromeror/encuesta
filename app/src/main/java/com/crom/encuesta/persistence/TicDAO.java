package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Hogar;
import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.model.TIC;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 11/07/16.
 */
public class TicDAO implements DAO<TIC, String> {

    private static int SIZE = 0;
    private static TicDAO ourInstance = new TicDAO();
    private static String TABLE_TIC = "tic";
    private static String TABLE_I3 = "I3";
    private static String TABLE_I4 = "I4";
    private static String i1 = "i1";
    private static String i2= "i2";
    private static String i5= "i5";
    private static String id= "id";
    private static String miembroId= "miembroId";
    //list
    private static String i3id = "i3id";
    private static String nombrei3 = "nombrei3";
    private static String i4id = "i4id";
    private static String nombrei4 = "nombrei4";

    public static TicDAO getInstance() {
        return ourInstance;
    }

    private TicDAO() {
    }

    @Override
    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_TIC + " ( " +
                id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                miembroId + " TEXT, " +
                i1 + " TEXT, " +
                i2 + " TEXT, " +
                i5 + " TEXT " +
                " )";
        db.execSQL(query);
        //Log.i("TABA Hogare", query);
        query= "CREATE TABLE " + TABLE_I3 + " ( " +
                i3id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                nombrei3 + " TEXT, " +
                id + " TEXT" +
                ")";
        db.execSQL(query);
        //Log.i("TABlA BIENES", query);
        query= "CREATE TABLE " + TABLE_I4 + " ( " +
                i4id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                nombrei4 + " TEXT, " +
                id + " TEXT" +
                ")";
        db.execSQL(query);
        //Log.i("TABlA BIENES", query);
    }

    @Override
    public TIC insert(TIC tic, SQLiteDatabase db) {
        SIZE = read(db).size();
        ContentValues values = new ContentValues();
        values.put(i1, SIZE+1);
        values.put(miembroId,tic.getMiembroId());
        values.put(i1,tic.getI1());
        values.put(i2,tic.getI2());
        values.put(i5,tic.getI5());
        if((db.insert( TABLE_TIC , null, values ) != -1)){
            for (String elementI3:tic.getI3()) {
                values = new ContentValues();
                values.put(id, SIZE+1);
                values.put(nombrei3,elementI3);
                if(!(db.insert( TABLE_I3 , null, values ) != -1))
                    tic.setI3(new ArrayList<String>());
            }
            for (String elementI4:tic.getI4()) {
                values = new ContentValues();
                values.put(id, SIZE+1);
                values.put(nombrei4,elementI4);
                if(!(db.insert( TABLE_I4 , null, values ) != -1))
                    tic.setI4(new ArrayList<String>());
            }
        }else return null;
        tic.setId((SIZE+1)+"");
        return tic;
    }

    @Override
    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_I3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_I4);
    }

    @Override
    public List<TIC> read(SQLiteDatabase db) {
        Cursor c = db.query(TABLE_TIC, null, null, null, null, null, null);
        ArrayList<TIC> tics = new ArrayList<>();
        //String[] args = new String[] {"Prueba"};
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                TIC tic = new TIC(c.getString(0),c.getString(1),c.getString(2),
                        c.getString(3), c.getString(4),
                        (ArrayList<String>) readI3(db, c.getString(0)),
                        (ArrayList<String>) readI4(db, c.getString(0)));
                tics.add(tic);
            }while (c.moveToNext());
        }
        return tics;
    }
    private List<String> readI3(SQLiteDatabase db, String id){
        ArrayList<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT "+nombrei3+" FROM "+TABLE_I3+" WHERE "+this.id+"="+id,null);
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                list.add(c.getString(0));
            } while (c.moveToNext());
        }
        return list;
    }

    private List<String> readI4(SQLiteDatabase db, String id){
        ArrayList<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT "+nombrei3+" FROM "+TABLE_I4+" WHERE "+this.id+"="+id,null);
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                list.add(c.getString(0));
            } while (c.moveToNext());
        }
        return list;
    }

    @Override
    public TIC read(SQLiteDatabase db, String id) {
        return null;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, TIC tic) {
        return false;
    }
}
