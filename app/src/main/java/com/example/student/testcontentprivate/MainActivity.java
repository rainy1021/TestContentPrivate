package com.example.student.testcontentprivate;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLTool sqlTool = new SQLTool(this);

        //Cursor cursor = sqlTool.queryAll();
        Cursor cursor = sqlTool.queryById(3);
        while (cursor.moveToNext()){
            Log.d("rain","Id:"+cursor.getInt(0));
            Log.d("rain","Title:"+cursor.getString(1));
            Log.d("rain","Price:"+cursor.getFloat(2));
        }

        /*ContentValues contentValues  = new ContentValues();
        contentValues.put("title","rain");
        contentValues.put("price",250);
        long id = sqlTool.insert(contentValues);
        Log.d("rain","id:"+id);
        contentValues.put("title","ocean");
        contentValues.put("price",200);
        id = sqlTool.insert(contentValues);
        Log.d("rain","id:"+id);
        contentValues.put("title","sky");
        contentValues.put("price",150);
        id = sqlTool.insert(contentValues);
        Log.d("rain","id:"+id);*/





       /* UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        Uri uri = Uri.parse("content://tw.com.howard.provider/query");
        uri = ContentUris.withAppendedId(uri,123);
        uriMatcher.addURI("tw.com.howard.provider","insert",10);
        uriMatcher.addURI("tw.com.howard.provider","query",100);
        uriMatcher.addURI("tw.com.howard.provider","query/#",200);

        Log.d("Howard:","XXXCode:"+uriMatcher.match(uri));

        switch (uriMatcher.match(uri)){
            case 200:
                long id =ContentUris.parseId(uri);
                Log.d("howard","id"+id);
            break;
        }*/
    }
}

