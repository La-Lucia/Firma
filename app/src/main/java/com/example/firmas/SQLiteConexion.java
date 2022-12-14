package com.example.firmas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteConexion extends SQLiteOpenHelper {

    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,dbname,factory,version);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Transacciones.CREATETABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Transacciones.DROPTABLE);
        onCreate(db);
    }

}
