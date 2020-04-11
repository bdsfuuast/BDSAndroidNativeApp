package com.fuuast.bds;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.fuuast.bds.Models.DonationDetailModel;

public class DialogDonationDetail extends AppCompatDialogFragment {
    DonationDetailModel donation;

    TextView type;
    TextView acceptTime;
    TextView bloodGroup;
    TextView requestTime;
    TextView requestBy;
    TextView time;
    TextView location;
    TextView currentStatus;

    public DialogDonationDetail(DonationDetailModel data){
        this.donation=data;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_donation_detail,null);

        type=view.findViewById(R.id.donation_type);
        acceptTime=view.findViewById(R.id.donation_accept_time);
        bloodGroup=view.findViewById(R.id.donation_bloodgroup);
        requestTime=view.findViewById(R.id.donation_request_time);
        requestBy=view.findViewById(R.id.donation_request_by);
        time=view.findViewById(R.id.donation_time);
        location=view.findViewById(R.id.donation_location);
        currentStatus=view.findViewById(R.id.donation_current_status);

        type.setText(donation.getType());
        acceptTime.setText(donation.getAcceptTime());
        bloodGroup.setText(donation.getBloodGroup());
        requestTime.setText(donation.getRequestTime());
        requestBy.setText(donation.getRequestBy());
        time.setText(donation.getTime());
        location.setText(donation.getLocation());
        currentStatus.setText(donation.getCurrentStatus());

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
//DialogDonationDetail