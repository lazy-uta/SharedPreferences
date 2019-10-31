package com.dicodingtraining.quizmobile.Helper;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

public class SharedPrefManager {
    @Nullable
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private final String SP_NAME = "loginsession";

    public static final String SP_NAMA = "nama" ;
    public static final String SP_PASSWD = "passwd";
    public static final String SP_DEVELOP = "namaku";
    public static final String SP_SUDAH_LOGIN = "sudah login" ;

    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_NAMA, Context.MODE_PRIVATE);
        sp = context.getSharedPreferences(SP_PASSWD, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        editor.putString(keySP, value);
        editor.commit();
    }


    public void saveSPBolean(String keySP, boolean value){
        editor.putBoolean(keySP, value);
        editor.commit();
    }


    public String getKeyNama() {
        return sp.getString(SP_NAMA, "");}

    public String getKeyPasswd() {
        return sp.getString(SP_PASSWD,"");
    }

   public String getSpDevelop() {return sp.getString(SP_DEVELOP, "");}


    public boolean Login(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
