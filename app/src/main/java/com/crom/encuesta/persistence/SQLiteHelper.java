package com.crom.encuesta.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static int VERSION = 1;
    public static String DATA_BASE = "EncuestaBD";

    ViviendaDAO viviendaDAO = ViviendaDAO.getInstance();
    HogarDAO hogarDAO = HogarDAO.getInstance();
    MiembroDAO miembroDAO = MiembroDAO.getInstance();
    SaludDAO saludDAO = SaludDAO.getInstance();

    public SQLiteHelper(Context contexto) {
        super(contexto, DATA_BASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        hogarDAO.create(db);
        viviendaDAO.create(db);
        miembroDAO.create(db);
        saludDAO.create(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        viviendaDAO.drop(db);
        hogarDAO.drop(db);
        miembroDAO.drop(db);
        saludDAO.drop(db);
        viviendaDAO.create(db);
        hogarDAO.create(db);
        miembroDAO.create(db);
        saludDAO.create(db);
    }
}