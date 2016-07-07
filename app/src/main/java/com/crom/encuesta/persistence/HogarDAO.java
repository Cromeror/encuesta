package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Hogar;
import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.model.Vivienda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristobal on 5/07/16.
 */
public class HogarDAO implements  DAO<Hogar, Integer>{

    private static int SIZE = 0;
    private static String TABLE_HOGAR = "hogar";
    private static String TABLE_BIENES = "bienes";
    private static String hogarId = "hogarId";
    private static String aguaConsumo = "aguaConsumo";
    private static String aguaOtroUso = "aguaOtroUso";
    private static String basura = "basura";
    private static String sanitarioHogar = "sanitarioHogar";
    private static String sanitarioVivienda = "sanitarioVivienda";
    private static String energiaCocinan = "energiaCocinan";
    //Bienes
    private static String serviciosBienesId = "serviciosBienesId";
    private static String nombreBienes = "nombreBienes";
    private static String viviendaId = "viviendaId";
    //miembros = new ArrayList<>();

    private static HogarDAO ourInstance = new HogarDAO();

    public static HogarDAO getInstance() {
        return ourInstance;
    }

    private HogarDAO() {
    }

    @Override
    public void create(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_HOGAR + " ( " +
                hogarId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                aguaConsumo + " TEXT, " +
                aguaOtroUso + " TEXT, " +
                basura + " TEXT, " +
                sanitarioHogar + " TEXT, " +
                sanitarioVivienda + " TEXT, " +
                energiaCocinan + " TEXT, " +
                viviendaId + " TEXT " +
                " )";
        db.execSQL(query);
        Log.i("TABA Hogare", query);
        query= "CREATE TABLE " + TABLE_BIENES + " ( " +
                serviciosBienesId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                hogarId + " TEXT, " +
                nombreBienes + " TEXT" +
                ")";
        db.execSQL(query);
        Log.i("TABA BIENES", query);
    }

    @Override
    public Hogar insert(Hogar hogar, SQLiteDatabase db) {
        SIZE = read(db).size();
        ContentValues values = new ContentValues();
        values.put(hogarId, SIZE+1);
        values.put(aguaConsumo,hogar.getAguaConsumo());
        values.put(aguaOtroUso,hogar.getAguaOtroUso());
        values.put(basura,hogar.getBasura());
        values.put(sanitarioHogar,hogar.getSanitarioHogar());
        values.put(sanitarioVivienda,hogar.getSanitarioVivienda());
        values.put(energiaCocinan,hogar.getEnergiaCocinan());
        values.put(viviendaId,hogar.getViviendaId());
        boolean result = false;
        Log.i("HogarDAO", "Nuevo registro Hogar" );
        if((db.insert( TABLE_HOGAR , null, values ) != -1)){
            for (String serviciosBienes:hogar.getServiciosBienes()) {
                values = new ContentValues();
                values.put(hogarId, SIZE+1);
                values.put(nombreBienes,serviciosBienes);
                 if(!(db.insert( TABLE_BIENES , null, values ) != -1))
                    hogar.setServiciosBienes(new ArrayList<String>());
            }
        }else return null;
        hogar.setId((SIZE+1)+"");
        return hogar;
    }

    @Override
    public void drop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIENES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOGAR);
    }

    @Override
    public List<Hogar> read(SQLiteDatabase db) {
        String[] campos = new String[] {hogarId,viviendaId,
                aguaConsumo,
                aguaOtroUso,
                basura,
                sanitarioHogar,
                sanitarioVivienda,
                energiaCocinan };
        Cursor c = db.query(TABLE_HOGAR, null, null, null, null, null, null);
        ArrayList<Hogar> hogars = new ArrayList<>();
        //String[] args = new String[] {"Prueba"};
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
               Hogar hogar = new Hogar(c.getString(0),c.getString(1),c.getString(2),
                        c.getString(3), c.getString(4),c.getString(5),c.getString(6),c.getString(7),
                       (ArrayList<Miembro>) MiembroDAO.getInstance().likeId(db, c.getString(0)),
                        (ArrayList<String>) readServicioBienes(db, c.getString(0)));
                Log.i("HogarDao", c.getString(0)+c.getString(1)+c.getString(2));
                hogars.add(hogar);
            }while (c.moveToNext());
        }
        return hogars;
    }
    private List<String> readServicioBienes(SQLiteDatabase db, String id){
        ArrayList<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT "+nombreBienes+" FROM "+TABLE_BIENES+" WHERE "+hogarId+"="+id,null);
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                list.add(c.getString(0));
                Log.i(this.getClass()+"Servicios bienes", c.getString(0));
            } while (c.moveToNext());
        }
        return list;
    }

    @Override
    public Hogar read(SQLiteDatabase db, String id) {
        return null;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, Hogar hogar) {
        return false;
    }
}
