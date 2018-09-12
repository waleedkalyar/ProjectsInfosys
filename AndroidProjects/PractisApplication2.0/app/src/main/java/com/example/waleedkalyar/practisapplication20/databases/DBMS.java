package com.example.waleedkalyar.practisapplication20.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WALEED KALYAR on 8/12/2017.
 */

public class DBMS extends SQLiteOpenHelper {
    public static String dbName = "UserDatabase.db";
    public static int dbVersion = 1;
    public String userQueryTable = "CREATE TABLE user_detail(Name TEXT,E_Mail TEXT,Password TEXT,Adress TEXT)";

    public DBMS(Context context) {
        super(context, dbName, null, dbVersion);
        Log.e("DBMS: ", "DataBase is developed");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(userQueryTable);
        Log.e("onCreate: ", "Table Is created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addUserDetailsIntoDb(SQLiteDatabase db, String name, String eMail, String pass, String adress) {
        ContentValues cv = new ContentValues();
        cv.put("Name", name);
        cv.put("E_Mail", eMail);
        cv.put("Password", pass);
        cv.put("Adress", adress);
        db.insert("user_detail", null, cv);
        Log.e("addUserDetailsIntoDb: ", "Data Enter kr dia hy");
    }

    public Cursor getAllUsersDataFromDb(SQLiteDatabase db) {
        String[] projections = new String[]{
                "Name",
                "E_Mail",
                "Password",
                "Adress"

        };
        Cursor mCursor = db.query("user_detail", projections, null, null, null, null, null);
        return mCursor;
    }

    public Cursor chackUserLogedIn(SQLiteDatabase db, String eMail, String pass) {
        Cursor mCursor = db.rawQuery("Select * from user_detail Where E_Mail='" + eMail + "' AND Password='" + pass + "'", null);
        return mCursor;
    }
    //public Cursor getUserDataInfo(SQLiteDatabase db ){
      //  Cursor c=db.execSQL("Select name from user_detail");
       // return c;
   // }
}
