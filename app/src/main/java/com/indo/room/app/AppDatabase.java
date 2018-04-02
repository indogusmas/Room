package com.indo.room.app;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.indo.room.database.Mahasiswa;
import com.indo.room.database.MahasiswaDao;

@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class AppDatabase  extends RoomDatabase{
    public abstract MahasiswaDao userDao();
}
