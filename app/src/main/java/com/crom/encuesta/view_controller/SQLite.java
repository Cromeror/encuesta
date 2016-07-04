package com.crom.encuesta.view_controller;

//
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLite {

	private BDSQLite BDsqlite;
	public SQLiteDatabase db;
	
	/** Constructor de clase */
	public SQLite(Context context){
		BDsqlite = new BDSQLite(context);
	}

	/** Abre conexion a base de datos */
	public void open(){
		Log.i("SQLite", "Se abre conexion a la base de datos " + BDsqlite.getDatabaseName());
		db = BDsqlite.getWritableDatabase();
	}
	
	/** Cierra conexion a la base de datos */
	public void cerrar(){
		Log.i("SQLite", "Se cierra conexion a la base de datos " + BDsqlite.getDatabaseName() );
		BDsqlite.close();		
	}
}
