package com.itcteam.panenkita.kebun.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.itcteam.panenkita.R;
import com.itcteam.panenkita.kebun.Kebun;

public class KebunDialog extends DialogFragment {
    private Kebun listener;
    private EditText nama_kebun;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_kebun, null);
        nama_kebun = view.findViewById(R.id.nama_kebun);
        builder.setView(view)
                .setTitle("Tambah Kebun")
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                })
                .setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String namaKebun = nama_kebun.getText().toString();
                        listener.terimaDataDialog(namaKebun);
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (Kebun) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " Kelasnya wajib ada ");
        }
    }

    public interface KebunDialogListener {
        public void terimaDataDialog(String nama_kebun);
    }
}
