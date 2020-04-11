package com.fuuast.bds;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.fuuast.bds.Models.AcceptDetailModel;

public class DialogAcceptDetail extends AppCompatDialogFragment {
    AcceptDetailModel accept;

    TextView type;
    TextView acceptTime;
    TextView bloodGroup;
    TextView requestTime;
    TextView requestBy;
    TextView currentStatus;

    public DialogAcceptDetail(AcceptDetailModel data){
        this.accept=data;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_accept_detail,null);

        type=view.findViewById(R.id.accept_type);
        acceptTime=view.findViewById(R.id.accept_time);
        bloodGroup=view.findViewById(R.id.accept_bloodgroup);
        requestTime=view.findViewById(R.id.accept_request_time);
        requestBy=view.findViewById(R.id.accept_request_by);
        currentStatus=view.findViewById(R.id.accept_current_status);

        type.setText(accept.getType());
        acceptTime.setText(accept.getAcceptTime());
        bloodGroup.setText(accept.getBloodGroup());
        requestTime.setText(accept.getRequestTime());
        requestBy.setText(accept.getRequestBy());
        currentStatus.setText(accept.getCurrentStatus());

        builder.setView(view)
                .setTitle("Detail")
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        return builder.create();
    }
}

//DialogAcceptDetail