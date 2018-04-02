package com.indo.room;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.indo.room.database.Mahasiswa;
import com.indo.room.utilities.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.indo.room.MyApp.db;

public class DetailActivity extends AppCompatActivity {
    private final String TAG = DetailActivity.class.getSimpleName();

    @BindView(R.id.recyclerview)
    RecyclerView mrecyclerView;
    RecyclerAdapter adapter;
    List<Mahasiswa>mahasiswaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        fetchDataFromDb();
        initRecyclerview();
        setadapter();

    }
    private void fetchDataFromDb(){
        mahasiswaList = db.userDao().getAll();
        /*
        *Checking data from database
         */
        for (int i = 0; i< mahasiswaList.size();i++){
            Log.e(TAG, "Data mahasiswa"+ mahasiswaList.get(i).getNama());
            Log.e(TAG, "Data mahasiswa"+ mahasiswaList.get(i).getAlamat());
            Log.e(TAG, "Data mahasiswa"+ mahasiswaList.get(i).getKejurusan());
            Log.e(TAG, "Data mahasiswa"+ mahasiswaList.get(i).getNim());
        }
    }
    private void initRecyclerview(){
        mrecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mrecyclerView.setLayoutManager(llm);
        adapter = new RecyclerAdapter(this, mahasiswaList);

    }
    private void setadapter(){
        mrecyclerView.setAdapter(adapter);
    }

}
















