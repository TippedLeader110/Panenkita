package com.itcteam.panenkita.ui.mainpage;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.itcteam.panenkita.R;
import com.itcteam.panenkita.db.DatabaseHandlerAppSave;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatabaseHandlerAppSave appSave;
    AlertDialog alertDialog;
    DaftarPanenRAdapter daftarPanenRAdapter;
    RecyclerView panenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        alertDialog = new AlertDialog.Builder(this).create();
        appSave = new DatabaseHandlerAppSave(this);
        panenList = findViewById(R.id.panen_list);

        getPanen();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long yourmilliseconds = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
                Date resultdate = new Date(yourmilliseconds);
                String mili = String.valueOf(yourmilliseconds);
                Snackbar.make(view, "Menambah entri baru pada tanggal \n"+ sdf.format(resultdate) , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                if (!appSave.createEntryPanen(mili)){
                    alertDialog.setTitle("Kesalahan");
                    alertDialog.setMessage("Gagal menambahkan entri baru !!!");
                }
                else{
                    getPanen();
                }

            }
        });
    }

    private void getPanen() {
        if (appSave.getPanen()!=null){
            daftarPanenRAdapter = new DaftarPanenRAdapter(this, appSave.getPanen());
            panenList.setAdapter(daftarPanenRAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setReverseLayout(true);
            linearLayoutManager.setStackFromEnd(true);
            panenList.setLayoutManager(linearLayoutManager);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}