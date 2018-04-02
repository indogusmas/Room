package com.indo.room.utilities;

import com.indo.room.database.Mahasiswa;

public interface OnclickRecycler {

    void onItemDismiss(int position);

    void updateListener(int id, Mahasiswa mahasiswa);
}
