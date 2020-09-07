package com.itcteam.panenkita.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHandlerAppSave extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "panendb";
    private static final String TABLE_PANEN = "panen";

    SQLiteDatabase db;
    private boolean notif;

    public DatabaseHandlerAppSave(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_KASUS = " CREATE TABLE " + TABLE_PANEN + " (" +
                "  id_panen INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "  waktu TEXT ," +
                "  keuntungan TEXT" +
                ") ";
        Log.w("BENTUK QUERY",CREATE_KASUS);
        db.execSQL(CREATE_KASUS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PANEN);
        onCreate(db);
    }

    public ArrayList<HashMap<String, String>> getPanen(){
        db = this.getReadableDatabase();
        ArrayList<HashMap<String, String>> daftarPanen = new ArrayList<>();
        Cursor cursor = db.rawQuery( "select * from "+TABLE_PANEN , null );
//        cursor.moveToLast();
        while (cursor.moveToNext()){
            HashMap<String,String> kasus = new HashMap<>();
            kasus.put("id",Integer.toString(cursor.getInt(cursor.getColumnIndex("id_panen"))));
            kasus.put("waktu",cursor.getString(cursor.getColumnIndex("waktu")));
            daftarPanen.add(kasus);
        }
        cursor.close();
        db.close();
        return daftarPanen;
    }

    public boolean checkRow(){
        db = this.getReadableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_PANEN, null);
        if (mCursor.moveToFirst())
        {
            Log.w("checkRow","Ada row");
            mCursor.close();
            db.close();
            return true;
        }
        else
        {
            Log.w("checkRow","Tidak Ada row");
            mCursor.close();
            db.close();
            return false;
        }
    }

    public boolean createEntryPanen(String waktu) {
        Log.w("Time", waktu);
        ContentValues contentValues = new ContentValues();
        contentValues.put("waktu", waktu);
        contentValues.put("keuntungan", "0");
        db = this.getWritableDatabase();
        if (db.insert(TABLE_PANEN, null, contentValues)!=-1){
            db.close();
            return true;
        }
        else{
            db.close();
            return false;
        }
    }
}
