package com.example.waleedkalyar.sessionmanagerpractise.dbmsPkg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WALEED KALYAR on 9/6/2017.
 */

public class DBMS extends SQLiteOpenHelper {
    public static String dbName="UserDatabase.db";
    public static int dbVersion=1;
    public static String userTableQuery="CREATE TABLE user_details(name TEXT,fname TEXT,email TEXT UNIQUE,adress TEXT,password TEXT)";

    public DBMS(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(userTableQuery);
        Log.e("onCreate","The db is created with table user_details");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertUserIntoDB(SQLiteDatabase db,String name,String fname,String email,String adress,String pass){
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("fname",fname);
        cv.put("email",email);
        cv.put("adress",adress);
        cv.put("password",pass);
        db.insert("user_details",null,cv);
        Log.e("insertUserIntoDB","The data is inserted into db");

      //  name TEXT,fname TEXT,email TEXT UNIQUE,adress TEXT,password TEXT
    }
    public Cursor getAllRegisterUsers(SQLiteDatabase db){
        String[]projections={
                "name",
                "fname",
                "email",
                "adress",
                "password"
        };
        Cursor mCursor=db.query("user_details",projections,null,null,null,null,null,null);
        return mCursor;
    }
    public Cursor chackUserLogedIn(SQLiteDatabase db,String email,String password){
        String[] selections={
                "name",
                "fname",
                "email",
                "adress",
                "password"
        };
        Cursor mCursor=db.rawQuery("SELECT * FROM user_details WHERE email='"+email+"' AND password='"+password+"'",null);
        return mCursor;
    }
}
