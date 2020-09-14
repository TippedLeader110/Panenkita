package com.itcteam.panenkita.kebun.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itcteam.panenkita.R;

import java.util.HashMap;
import java.util.List;

public class DaftarKebunRAdapter extends RecyclerView.Adapter<DaftarKebunRAdapter.DaftarKebunViewHolder> {

    private Context mcontext;
    private List daftarKebun;

    public DaftarKebunRAdapter(Context mcontext, List daftarKebun) {
        this.mcontext = mcontext;
        this.daftarKebun = daftarKebun;
    }


    @NonNull
    @Override
    public DaftarKebunViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.recycler_view_daftarkebun, null);
        return new DaftarKebunViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarKebunViewHolder holder, int position) {
        HashMap<String, String> value = (HashMap<String, String>) daftarKebun.get(position);
        holder.nama_kebun.setText(value.get("nama_kebun"));
    }

    @Override
    public int getItemCount() {
        return daftarKebun.size();
    }

    public class DaftarKebunViewHolder extends RecyclerView.ViewHolder{

        TextView nama_kebun;

        public DaftarKebunViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_kebun = itemView.findViewById(R.id.view_namakebun);
        }
    }

}
