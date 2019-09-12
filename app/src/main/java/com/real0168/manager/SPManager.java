package com.real0168.manager;

import android.content.Context;

/**
 * Created by lanmi on 2018/9/29.
 */

public class SPManager {
    private final String SP_NAME = "Example_sp";
    private volatile static SPManager instance;
    private Context mContext;
    public static SPManager getInstance(){
        if (instance == null){
            synchronized (SPManager.class){
                if (instance == null){
                    instance = new SPManager();
                }
            }
        }
        return instance;
    }
    private SPManager(){

    }
    public static void initManager(Context context){
        getInstance().mContext = context;
    }

    public boolean getBooleanValueFromSP(String key){
        if (mContext == null){
            return false;
        }
        return mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
                .getBoolean(key, false);
    }
    public void setBooleanValueToSP(String key, boolean value){
        if (mContext == null){
            return;
        }
        mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit().putBoolean(key, value).apply();
    }

    public int getIntValueFromSP(String key){
        if (mContext == null){
            return 0;
        }
        return mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
                .getInt(key, 0);
    }
    public void setIntValueToSP(String key, int value){
        if (mContext == null){
            return;
        }
        mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit().putInt(key, value).apply();
    }

    public String getStringValueFromSP(String key){
        if (mContext == null){
            return "";
        }
        return mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
                .getString(key, "");
    }
    public void setStringValueToSP(String key, String value){
        if (mContext == null){
            return;
        }
        mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit().putString(key, value).apply();
    }
}
