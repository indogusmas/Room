package com.indo.room.utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.indo.room.DetailActivity;
import com.indo.room.R;
import com.indo.room.database.Mahasiswa;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements OnclickRecycler {

    private Context context;
    private List<Mahasiswa> myList;
    OnclickRecycler onclickRecycler = this;

    public RecyclerAdapter(Context context, List<Mahasiswa> mahasiswaList) {
        this.context =context;
        this.myList = mahasiswaList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Mahasiswa album = myList.get(position);
        holder.tvnama.setText(album.getNama());
        holder.tvNim.setText(album.getNim());
        holder.tvAlamat.setText(album.getAlamat());
        holder.tvKejurusan.setText(album.getKejurusan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Click "+ album.getNama(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    @Override
    public void onItemDismiss(int position) {

    }

    @Override
    public void updateListener(int id, Mahasiswa mahasiswa) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvNama)
        TextView tvnama;
        @BindView(R.id.tvNim)
        TextView tvNim;
        @BindView(R.id.tvAlamat)
        TextView tvAlamat;
        @BindView(R.id.tvKejuruan)
        TextView tvKejurusan;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
