package com.example.waleedkalyar.sqlltepractise.dbmsPkg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WALEED KALYAR on 8/9/2017.
 */

public class DBMS extends SQLiteOpenHelper {
    public static String dbName="UserDatabase.db";
    public static int dbVersion=1;
    public static String userDetailTableQuery="CREATE TABLE user_detail(p_name TEXT PRIMERY KEY,p_fname TEXT UNIQUE,p_password TEXT,p_adress TEXT)";

    public DBMS(Context context) {
        super(context, dbName, null, dbVersion);
        Log.e("DBMS=>","yes db bna dhy" );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(userDetailTableQuery);
        Log.e("ONCREATE=>","yes db me table bn gia hy" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertNewUserIntoDb(SQLiteDatabase db,String name,String fName,String pass,String adress){
     //db.execSQL("INSERT INTO Values(waleed,fazil,23er,SGD");
        ContentValues cv=new ContentValues();
        cv.put("p_name",name);
        cv.put("p_fname",fName);
        cv.put("p_password",pass);
        cv.put("p_adress",adress);

        db.insert("user_detail",null,cv);
        Log.e("insertNewUserIntoDb","data is inserted");
    }//p_name TEXT,p_fname TEXT,p_password TEXT,p_adress TEXT

    public Cursor getAllRegisterUsers(SQLiteDatabase db){
        String [] projections={
                "p_name",
                "p_fname",
                "p_password",
                "p_adress",
        };
        Cursor mCursor=db.query("user_detail",projections,null,null,null,null,null);
        return mCursor;
    }
    public Cursor chackUserLogedIn(SQLiteDatabase db,String name,String password){
     //boolean b=   db.execSQL("SELECT * FROM user_detail WHERE p_name="+name+",p_password="+password);
        String [] selectionArgs={
                "p_name",
                "p_fname",
                "p_password",
                "p_adress",
        };
        Cursor mCursor = db.rawQuery("SELECT * FROM user_detail WHERE p_name='"+name+"' AND p_password='"+password+"'",null);
        return mCursor;
    }
}
