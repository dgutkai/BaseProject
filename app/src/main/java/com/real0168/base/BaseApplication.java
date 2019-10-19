package com.real0168.base;

import android.app.Application;

import com.real0168.utils.LogToFile;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogToFile.init(this);
    }
}
