package com.example.waleedkalyar.customlistviewpractice.DBMS;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WALEED KALYAR on 8/10/2017.
 */

public class DBMS extends SQLiteOpenHelper {
    public static String dbName="UserDatabase.db";
    public static int dbVersion= 1;
    public String userTableQuery="Create Table user_info(P_Name TEXT,P_FName TEXT,P_Password TEXT,P_Adress TEXT)";

    public DBMS(Context context) {
        super(context, dbName, null, dbVersion);
        Log.e("DBMS=>","yes db bn gai hy");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(userTableQuery);
        Log.e("CREATETABLE=>","yes db me table bn gia hy");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
