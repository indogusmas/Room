package com.indo.room;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.indo.room.app.AppDatabase;
import com.indo.room.database.Mahasiswa;
import com.indo.room.database.MahasiswaDao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;

import static com.indo.room.MyApp.db;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etNama)
    EditText ednama;
    @BindView(R.id.etNim)
    EditText edNim;
    @BindView(R.id.etAlamat)
    EditText edAlamat;
    @BindView(R.id.etKejuruan)
    EditText edKejurusan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Inisialisasi Stetho
        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @OnClick(R.id.btInsert)
    void Insert(){
        if (!ednama.getText().toString().isEmpty()|| !edNim.getText().toString().isEmpty()||
                !edAlamat.getText().toString().isEmpty()|| !edKejurusan.getText().toString().isEmpty()){
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNama(ednama.getText().toString());
            mahasiswa.setNim(edNim.getText().toString());
            mahasiswa.setAlamat(edAlamat.getText().toString());
            mahasiswa.setKejurusan(edKejurusan.getText().toString());
            db.userDao().insertAll(mahasiswa);
            startActivity(new Intent(MainActivity.this,DetailActivity.class));
        }else {
            Toast.makeText(MainActivity.this, "Lengkapi Data", Toast.LENGTH_LONG).show();
        }
    }
}
