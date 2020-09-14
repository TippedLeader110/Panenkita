package com.itcteam.panenkita.simpletask;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class SimpleAlertDialog {
    private Context mcontext;
    AlertDialog alertDialog;

    public SimpleAlertDialog(Context mcontext) {
        this.mcontext = mcontext;
    }

    public void tampilDialogDefault(String judul, String isi){
        alertDialog = new AlertDialog.Builder(mcontext).create();
        alertDialog.setTitle(judul);
        alertDialog.setMessage(isi);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
