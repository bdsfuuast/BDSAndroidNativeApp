package com.fuuast.bds;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;


public class ProgressDialog {
    private Activity activity;
    private AlertDialog dialog;
    public ProgressDialog(Activity activity){
        this.activity=activity;
    }
    void show(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
        LayoutInflater inflater=this.activity.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.progress_dialog,null));
        builder.setCancelable(false);

        dialog=builder.create();
        dialog.show();
        dialog.getWindow().setLayout(500,400);
    }
    void dismiss(){
        dialog.dismiss();
    }
}
