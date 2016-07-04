package com.crom.encuesta.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.crom.encuesta.model.Vivienda;

/**
 * Created by Katherine Buelvas on 03/07/2016.
 */
public class ViviendaDAO implements DAO<Vivienda, Integer> {
    private  static String TABLE = "vivienda";
    private static String persona_id = "persona_id";
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
    private static String cuartosId = "cuartos_id";
    private static String serviciosId = "servicios_id";
    private static String hogaresId = "hogares_id";

    @Override
    public void create(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE + " ( " +
                persona_id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                departamento + " TEXT, " +
                municipio + " TEXT, " +
                zona + " TEXT, " +
                barrio + " TEXT, " +
                sector + " TEXT " +
                direccion + " TEXT " +
                tipoVivienda + " TEXT " +
                propiedadVivienda + " TEXT " +
                cuantoPagan + " TEXT " +
                materialPisos + " TEXT " +
                materialParedesExteriores + " TEXT " +
                cuartosId + " TEXT " +
                serviciosId + " TEXT " +
                hogaresId + " TEXT " +
                " )";
        db.execSQL(query);
    }

    @Override
    public boolean insert(Vivienda vivienda, SQLiteDatabase db) {
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
        Log.i("SQLite", "Nuevo registro Persona" );
        return (db.insert( TABLE , null, values ) != -1)?true:false;
    }

    public void drop(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    @Override
    public Cursor read(SQLiteDatabase db, Integer integer) {
        /*Cursor cursor = db.query(TABLE,
            new String[]{persona_id,
                    departamento,
                    municipio,
                    zona,
                    barrio,
                    sector},
            integer+"", null, null, null, null);

*/
        String[] campos = new String[] {departamento, municipio, barrio, zona};
        String[] args = new String[] {"Prieba"};
        Cursor cursor = db.query(TABLE, campos, departamento+"=?", args, null, null, null);
        return cursor;
    }
}
