package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Vivienda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katherine Buelvas on 03/07/2016.
 */
public class ViviendaDAO implements DAO<Vivienda, String> {
    private  static String TABLE_VIVIENDA = "vivienda";
    private  static String TABLE_CUARTO = "cuarto";
    private  static String TABLE_SERVICIO = "servicio";
    private static String viviendaId = "viviendaId";
    private static String departamento = "departamento";
    private static String municipio = "municipio";
    private static String zona = "zona";
    private static String barrio = "barrio";
    private static String sector = "sector";
    private static String direccion = "direccion";
    private static String tipoVivienda = "tipo_vivienda";
    private static String propiedadVivienda = "propiedad_vivienda";
    private static String cuantoPagan = "cuanto_pagan";
    private static String materialPisos = "material_piso";
    private static String materialParedesExteriores = "material_paredes";
    //Table cuarto
    private static String cuartosId = "cuartos_id";
    private static String personasCuartos = "numero_persona";
    //Table Servicio
    private static String serviciosId = "servicios_id";
    private static String nombreServicio = "nombre_servicio";
    //
    private static String hogaresId = "hogares_id";

    public static int SIZE = 0;

    private static ViviendaDAO instance = null;
    private ViviendaDAO() {
    }

    public static ViviendaDAO getInstance() {
        if(instance == null)
            instance = new ViviendaDAO();
        return instance;
    }

    @Override
    public void create(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_VIVIENDA + " ( " +
                viviendaId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                departamento + " TEXT, " +
                municipio + " TEXT, " +
                zona + " TEXT, " +
                barrio + " TEXT, " +
                sector + " TEXT, " +
                direccion + " TEXT, " +
                tipoVivienda + " TEXT, " +
                propiedadVivienda + " TEXT, " +
                cuantoPagan + " TEXT, " +
                materialPisos + " TEXT, " +
                materialParedesExteriores + " TEXT " +
                " )";
        db.execSQL(query);
        Log.i("Vivienta table", query);
        query= "CREATE TABLE " + TABLE_CUARTO + " ( " +
                cuartosId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                viviendaId + " TEXT, " +
                personasCuartos + " TEXT" +
                ")";
        db.execSQL(query);
        Log.i("Vivienta cuarto", query);
        query ="CREATE TABLE " + TABLE_SERVICIO+ " ( " +
                        serviciosId + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        viviendaId + " TEXT, " +
                        nombreServicio + " TEXT" +
                        ")";
        db.execSQL(query);
        Log.i("Vivienta servicio", "d");
    }

    @Override
    public Vivienda insert(Vivienda vivienda, SQLiteDatabase db) {
        SIZE = ((ArrayList) read(db)).size();
        ContentValues values = new ContentValues();
        values.put(viviendaId, SIZE+1);
        values.put(departamento,vivienda.getDepartamento());
        values.put(municipio,vivienda.getDepartamento());
        values.put(zona,vivienda.getDepartamento());
        values.put(barrio,vivienda.getDepartamento());
        values.put(sector, vivienda.getSector());
        values.put(direccion, vivienda.getDireccion());
        values.put(tipoVivienda, vivienda.getTipoVivienda());
        values.put(propiedadVivienda, vivienda.getPropiedadVivienda());
        values.put(cuantoPagan, vivienda.getCuantoPagan());
        values.put(materialPisos, vivienda.getMaterialPisos());
        values.put(materialParedesExteriores, vivienda.getMaterialParedesExteriores());
        boolean result = false;
        Log.i("ViviendaDAO", "Nuevo registro Vivienda" );
        if((db.insert( TABLE_VIVIENDA , null, values ) != -1)){
            for (String personas:vivienda.getCuartos()) {
                values = new ContentValues();
                values.put(personasCuartos,personas);
                values.put(viviendaId, SIZE+1);
                if(!(db.insert( TABLE_CUARTO , null, values ) != -1))
                    vivienda.setCuartos(new ArrayList<String>());
            }
            if(result) {
                for (String servicios : vivienda.getServicios()) {
                    values = new ContentValues();
                    values.put(nombreServicio, servicios);
                    values.put(viviendaId, SIZE + 1);
                    if(!(db.insert( TABLE_SERVICIO , null, values ) != -1))
                        vivienda.setServicios(new ArrayList<String>());
                }
            }
        }else return null;
        vivienda.setId((SIZE+1)+"");
        return vivienda;
    }

    public void drop(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIVIENDA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUARTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERVICIO);
    }

    @Override
    public List<Vivienda> read(SQLiteDatabase db) {
        String[] campos = new String[] {viviendaId,departamento, municipio, zona, barrio, sector,direccion, tipoVivienda
        ,propiedadVivienda, cuantoPagan, materialPisos, materialParedesExteriores};
        Cursor c = db.query(TABLE_VIVIENDA, campos, null, null, null, null, null);
        ArrayList<Vivienda> viviendas = new ArrayList<>();
        //String[] args = new String[] {"Prueba"};
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                Vivienda vivienda = new Vivienda(c.getString(0),c.getString(1),c.getString(2),c.getString(3),
                    c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                    c.getString(10),c.getString(11),(ArrayList<String>) readCuartos(db, c.getString(0)),
                        (ArrayList<String>) readServicio(db, c.getString(0)),null);
            viviendas.add(vivienda);
            }while (c.moveToNext());
        }
        return viviendas;
    }

    @Override
    public Vivienda read(SQLiteDatabase db, String id) {
        Vivienda vivienda = null;
        String[] campos = new String[] {viviendaId,departamento, municipio, zona, barrio, sector,direccion, tipoVivienda
                ,propiedadVivienda, cuantoPagan, materialPisos, materialParedesExteriores};
        String[] args = new String[] {id};
        Cursor c = db.query(TABLE_VIVIENDA, campos, viviendaId+"=?", args, null, null, null);
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                vivienda= new Vivienda(c.getString(0),c.getString(1),c.getString(2),c.getString(3),
                        c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9),
                        c.getString(10),c.getString(11),(ArrayList<String>) readCuartos(db, c.getString(0)),
                        (ArrayList<String>) readServicio(db, c.getString(0)),null);
            }while (c.moveToNext());
        }
        return vivienda;
    }

    @Override
    public boolean update(SQLiteDatabase db, String id, Vivienda vivienda) {
        ContentValues values = new ContentValues();
        values.put(departamento,vivienda.getDepartamento());
        values.put(municipio,vivienda.getDepartamento());
        values.put(zona,vivienda.getDepartamento());
        values.put(barrio,vivienda.getDepartamento());
        values.put(sector, vivienda.getSector());
        values.put(direccion, vivienda.getDireccion());
        values.put(tipoVivienda, vivienda.getTipoVivienda());
        values.put(propiedadVivienda, vivienda.getPropiedadVivienda());
        values.put(cuantoPagan, vivienda.getCuantoPagan());
        values.put(materialPisos, vivienda.getMaterialPisos());
        values.put(materialParedesExteriores, vivienda.getMaterialParedesExteriores());
        boolean result = false;
        return result;
    }

    private List<String> readCuartos(SQLiteDatabase db, String id){
        ArrayList<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT "+personasCuartos+" FROM "+TABLE_CUARTO+" WHERE "+viviendaId+"="+id,null);
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                list.add(c.getString(0));
                Log.i(this.getClass()+"cuarto", c.getString(0));
            } while (c.moveToNext());
        }
        return list;
    }
    private List<String> readServicio(SQLiteDatabase db, String id){
        ArrayList<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT "+nombreServicio+" FROM "+TABLE_SERVICIO+" WHERE "+viviendaId+"="+id,null);
        if (c.moveToFirst()&&c.getCount()>0) {
            do {
                list.add(c.getString(0));
                Log.i(this.getClass()+"servicio", c.getString(0));
            } while (c.moveToNext());
        }
        return list;
    }
}
