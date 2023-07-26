package com.sveri.foodapplicaion.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sveri.foodapplicaion.Helper.Helper;


public class Database {
    public static final String MY_DB = "food";
    SQLiteDatabase sdb;
    Cursor cursor;
    Helper mh;
    Context myContext;

    public Database(Context context) {
        this.myContext = context;
        mh = new Helper(myContext, MY_DB, null, 1);

    }
    public void insertOrder(ContentValues cv) {
        sdb = mh.getWritableDatabase();
        sdb.insert("food ", null, cv);

    }

    public Cursor getData() {
        sdb = mh.getReadableDatabase();
        cursor = sdb.query("food", null, null, null, null, null, null);
        return cursor;

    }
}
