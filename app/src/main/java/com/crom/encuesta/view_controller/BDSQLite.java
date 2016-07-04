package com.crom.encuesta.view_controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.crom.encuesta.persistence.ViviendaDAO;

public class BDSQLite extends SQLiteOpenHelper {
	private ViviendaDAO viviendaDAO = new ViviendaDAO();

	//nombre de la base de datos
	private static final String DATABASE = "Encuesta";

	//versi�n de la base de datos
	private static final int VERSION = 3;

	//Constructor de clase
	public BDSQLite(Context context) {
		super(context,DATABASE,null,VERSION);
	}

	//Creando las tablas
	@Override
	public void onCreate(SQLiteDatabase db) {
		viviendaDAO.create(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion ) {
		viviendaDAO.drop(db);
		viviendaDAO.create(db);
	}
}
