package com.example.bt2_app;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SessionManager.getInstance().init(this);

    }
}