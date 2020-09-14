package com.itcteam.panenkita.daftarpanen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itcteam.panenkita.R;
import com.itcteam.panenkita.kebun.Kebun;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DaftarPanenRAdapter extends RecyclerView.Adapter<DaftarPanenRAdapter.DaftarPanenViewHolder> {

    private Context context;
    private List listPanen;
    private int now;
    private MainActivity listener;
    Random r;
    int i1 ;
    List<String> colors;
    GradientDrawable draw;

    public DaftarPanenRAdapter(Context context, List dataPanen){
        this.context = context;
        this.listPanen = dataPanen;
        this.now = listPanen.size();
        colors=new ArrayList<String>();
        r = new Random();
        draw = new GradientDrawable();

        colors.add("#5E97F6");
        colors.add("#9CCC65");
        colors.add("#FF8A65");
        colors.add("#9E9E9E");
        colors.add("#9FA8DA");
        colors.add("#90A4AE");
        colors.add("#AED581");
        colors.add("#F6BF26");
        colors.add("#FFA726");
        colors.add("#4DD0E1");
        colors.add("#BA68C8");
        colors.add("#A1887F");

        try {
            this.listener =(MainActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " Kelasnya wajib ada ");
        }
    }

    @NonNull
    @Override
    public DaftarPanenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_daftarentry, null);
        return new DaftarPanenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarPanenViewHolder holder, int position) {
        final HashMap<String,String> value = (HashMap<String, String>) listPanen.get(position);
        long yourmilliseconds = Long.parseLong(value.get("waktu"));
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMMM yyyy",  java.util.Locale.getDefault());
        Date resultdate = new Date(yourmilliseconds);

        draw.setShape(GradientDrawable.OVAL);
        i1 = r.nextInt(11- 0) + 0;
        draw.setColor(Color.parseColor(colors.get(i1)));
        holder.auto.setText(String.valueOf(position+1));
        holder.auto.setBackground(draw); //textview
        holder.waktuPanen.setText(sdf.format(resultdate));
        holder.panen.setText("Panen "+ String.valueOf(position+1));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Kebun.class);
                intent.putExtra("id_panen", value.get("id"));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  listPanen.size();
    }

    public class DaftarPanenViewHolder extends RecyclerView.ViewHolder{

        TextView waktuPanen, id, auto, panen;

        public DaftarPanenViewHolder(View view) {
            super(view);
            auto = view.findViewById(R.id.autoText);
            waktuPanen = view.findViewById(R.id.tanggal_panen);
            id = view.findViewById(R.id.id_panen);
            panen = view.findViewById(R.id.panen_title);

        }
    }

}
