package com.indo.room;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.indo.room.app.AppDatabase;

public class MyApp extends Application {
    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
    }
}
