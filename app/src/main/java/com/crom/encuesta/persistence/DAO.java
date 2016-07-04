package com.crom.encuesta.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Katherine Buelvas on 03/07/2016.
 */
public interface DAO<T, I> {
    public void create(SQLiteDatabase db);
    public boolean insert(T t, SQLiteDatabase db);
    public void drop(SQLiteDatabase db);
    public Cursor read(SQLiteDatabase db,I i);
}
