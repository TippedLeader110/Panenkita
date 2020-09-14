package com.itcteam.panenkita.kebun;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.itcteam.panenkita.R;
import com.itcteam.panenkita.db.DatabaseHandlerAppSave;
import com.itcteam.panenkita.kebun.ui.dialog.KebunDialog;
import com.itcteam.panenkita.kebun.ui.main.BiayaPokokFragment;
import com.itcteam.panenkita.kebun.ui.main.DaftarKebunFragment;
import com.itcteam.panenkita.kebun.ui.main.SectionsPagerAdapter;
import com.itcteam.panenkita.simpletask.SimpleAlertDialog;

public class Kebun extends AppCompatActivity implements KebunDialog.KebunDialogListener {
    FloatingActionButton fab;
    private KebunDialog kebunDialog;
    SimpleAlertDialog sad;
    String id_panen;
    private DatabaseHandlerAppSave appSave;
    ProgressDialog pd;
    SectionsPagerAdapter sectionsPagerAdapter;
    TabLayout tabs;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appSave = new DatabaseHandlerAppSave(this);
        sad = new SimpleAlertDialog(this);
        pd = new ProgressDialog(this);
        setContentView(R.layout.activity_daftar_kebun);
        id_panen = getIntent().getStringExtra("id_panen");
        Log.w("id_panen", id_panen);
        initFragment();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                kebunDialog = new KebunDialog();
                kebunDialog.show(getSupportFragmentManager(), "Tambah Kebun");
            }
        });


    }

    private void initFragment() {
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), id_panen);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void terimaDataDialog(String nama_kebun) {
        pd.setTitle("Menambah Kebun");
        pd.setMessage("Harap tunggu !!!");
        pd.show();
        if (pd.isShowing()){
            if (appSave.tambahKebun(nama_kebun, Integer.parseInt(id_panen))){
                sad.tampilDialogDefault("Berhasil", "Kebun berhasil ditambah");
                initFragment();
            }
            else{
                sad.tampilDialogDefault("Gagal", "Kebun gagal ditambah");
            }
            pd.dismiss();
        }
    }
}