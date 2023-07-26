package com.sveri.foodapplicaion.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public Helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE food(_id INTEGER PRIMARY KEY ,name TEXT, items INTEGER,total INTEGER);";
        sqLiteDatabase.execSQL(query);
        Log.i("food DB","Database Created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
