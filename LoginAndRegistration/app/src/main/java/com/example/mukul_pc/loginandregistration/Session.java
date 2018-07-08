package com.example.mukul_pc.loginandregistration;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUseName(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public String getUseName() {
        String usename = prefs.getString("usename","");
        return usename;
    }

    public void destroy(Context cntx) {
        cntx.getSharedPreferences("YOUR_PREFS", 0).edit().clear().commit();
    }
}