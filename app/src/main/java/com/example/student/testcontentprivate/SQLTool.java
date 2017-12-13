package com.example.student.testcontentprivate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Student on 2017/12/1.
 */

public class SQLTool extends SQLiteOpenHelper {
    public static final  String TABLE_NAME = "msg_list";
    public static final String CREATE_TABLE_SQL = "CREATE TABLE "+
            TABLE_NAME +" (_id INTEGER PRIMARY KEY,"+
            "title TEXT,"+
            "price NUMERIC);";
    public static final String DB_NAME = "MSG.db";
    public static final int VESTION=1;


    public SQLTool(Context context) {
        super(context, DB_NAME, null, VESTION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
        Log.d("Howard","Create DB Complete!");
    }

    public long  insert(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        long id = db.insert(TABLE_NAME,null,contentValues);
        return id;
    }

    Cursor queryAll(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }

    Cursor queryById(long id){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE _id =?";
        Cursor cursor = db.rawQuery(sql,new String[]{id+""});
        return cursor;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
