package com.crom.encuesta.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by Katherine Buelvas on 03/07/2016.
 */
public interface DAO<T, I> {
    public void create(SQLiteDatabase db);
    public T insert(T t, SQLiteDatabase db);
    public void drop(SQLiteDatabase db);
    public List<T> read(SQLiteDatabase db);
    public T read(SQLiteDatabase db, String id);
    public boolean update(SQLiteDatabase db, String id, T t);
}
