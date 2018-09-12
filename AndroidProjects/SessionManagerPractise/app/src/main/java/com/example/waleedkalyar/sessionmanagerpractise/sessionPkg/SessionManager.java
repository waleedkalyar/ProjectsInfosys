package com.example.waleedkalyar.sessionmanagerpractise.sessionPkg;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by WALEED KALYAR on 9/5/2017.
 */

public class SessionManager {
    SharedPreferences mPref;
    SharedPreferences.Editor mEditor;

    public static final String mPrefName="loginPref";
    // mode tells us either pref is public(0) or private(1)
    public static final int mPrefMode=0;
    public SessionManager(Context context){
mPref=context.getSharedPreferences(mPrefName,mPrefMode);
        mEditor=mPref.edit();
    }

// now we will make a custom method for storing the session of the app
    public void loginTheUser(String eMail,String password,boolean logType){
        mEditor.putString("incomming_email",eMail);
        mEditor.putString("incomming_pass",password);
        mEditor.putBoolean("incomming_logtype",logType);
        mEditor.commit();
    }

    //how to chack either user is logedin or not???
    // we will make a method for it

    public boolean chackUserInSession(){
        return mPref.getBoolean("incomming_logtype",false);
    }
    // give the written password in the pref else empty value
    public String chackUserInSessionPass(){
        return mPref.getString("incomming_pass","");
    }
    // give the written email in the pref else empty value
    public String chackUserInSessionEmail(){
        return mPref.getString("incomming_email","");
    }
}
