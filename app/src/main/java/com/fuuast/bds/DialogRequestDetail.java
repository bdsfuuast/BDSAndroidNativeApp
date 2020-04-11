package com.fuuast.bds;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;


import com.fuuast.bds.Models.RequestDetailModel;

public class DialogRequestDetail extends AppCompatDialogFragment {
    RequestDetailModel request;
    ProgressDialog sentProg;
    public DialogRequestDetail(RequestDetailModel data,ProgressDialog prog){
        this.request=data; sentProg=prog;
    }
    TextView type;
    TextView donorName;
    TextView bloodGroup;
    TextView sentTo;
    TextView seenBy;
    TextView time;
    TextView date;
    TextView acceptedBy;
    TextView currentStatus;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_request_detail,null);

        type=view.findViewById(R.id.request_type);
        donorName=view.findViewById(R.id.request_donor_name);
        bloodGroup=view.findViewById(R.id.request_bloodgroup);
        sentTo=view.findViewById(R.id.request_sent_to);
        seenBy=view.findViewById(R.id.request_seen_by);
        time=view.findViewById(R.id.request_time);
        date=view.findViewById(R.id.request_date);
        acceptedBy=view.findViewById(R.id.request_accepted_by);
        currentStatus=view.findViewById(R.id.request_current_status);

        type.setText(request.getType());
        donorName.setText(request.getDonorName());
        bloodGroup.setText(request.getBloodGroup());
        sentTo.setText(request.getSentTo().toString());
        seenBy.setText(request.getSeenBy().toString());
        time.setText(request.getTime());
        date.setText(request.getDate());
        acceptedBy.setText(request.getAcceptedBy().toString());
        currentStatus.setText(request.getCurrentStatus());

        builder.setView(view)
                .setTitle("Detail")
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        sentProg.dismiss();
        return builder.create();
    }
}
