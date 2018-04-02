package com.indo.room.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MahasiswaDao {
    @Query("Select * from mahasiswa")
    List<Mahasiswa>getAll();

    //Example Custom Query
    @Query("Select * from mahasiswa where nama like :nama")
    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa... mahasiswa);

    @Delete
    public void deleteUser(Mahasiswa... users);

}
