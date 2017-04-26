package com.lcpay.pos.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.SharedPreferencesCompat;

public enum PreferencesHelper {

    INSTANCE;

    private SharedPreferences preferences;

    PreferencesHelper() {
        preferences = PreferenceManager.getDefaultSharedPreferences(PosApplicationContext.context);
    }

    public int getVersionCode() {
        return preferences.getInt("version_code", -1);
    }

    public void setVersionCode(int versionCode) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("version_code", versionCode);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

}
