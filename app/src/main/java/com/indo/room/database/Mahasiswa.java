package com.indo.room.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Mahasiswa {

    @PrimaryKey(autoGenerate =  true)
    int id;

    @ColumnInfo(name = "nama")
    String nama;

    @ColumnInfo(name= "nim")
    String nim;

    @ColumnInfo(name = "kejurusan")
    String kejurusan;

    @ColumnInfo(name = "alamat")
    String alamat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKejurusan() {
        return kejurusan;
    }

    public void setKejurusan(String kejurusan) {
        this.kejurusan = kejurusan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
