package com.fuuast.bds;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuuast.bds.Models.AcceptDetailModel;
import com.fuuast.bds.Models.AppDeserializer;
import com.fuuast.bds.Models.BDSApi;
import com.fuuast.bds.Models.BDSApiHelper;
import com.fuuast.bds.Models.DonationDetailModel;
import com.fuuast.bds.Models.HistoryModel;
import com.fuuast.bds.Models.Post;
import com.fuuast.bds.Models.ProfileModel;
import com.fuuast.bds.Models.RequestDetailModel;
import com.fuuast.bds.Models.ResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryFragment extends Fragment implements HistoryAdapter.OnHistoryListener , BDSApiHelper.HistoryApiCallFinish {
    RecyclerView rv_history;
    List<HistoryModel> history;
    ProgressDialog progress;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view=view;
        progress = new ProgressDialog(getActivity());
        rv_history = view.findViewById(R.id.rv_history);
        Log.i("myBeforeCall", "Before Call ");
        //new BDSApiHelper().getDonationDetail(view,this);
        progress.show();
        new BDSApiHelper().getHistory(view,this);
    }

    @Override
    public void onHistoryClick(int position) {
        Log.i("myClick", "position "+history.get(position).getDescription());
        HistoryModel hist=history.get(position);
        progress.show();
        switch (hist.getType()){
            case "req":{
                new BDSApiHelper().getRequestDetail(this.view,this,hist.ID);
                break;
            }
            case "acp":{
                new BDSApiHelper().getAcceptDetail(this.view,this,hist.ID);
                break;
            }
            case "don":{
                new BDSApiHelper().getDonationDetail(this.view,this,hist.ID);
                break;
            }
            default:progress.dismiss();
        }
    }

    @Override
    public void OnHistorySuccess(View view, Object data) {
        history=(List<HistoryModel>)data;
        RecyclerView recyclerView = view.findViewById(R.id.rv_history);
        HistoryAdapter adapter = new HistoryAdapter(this.getContext(), history,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
        progress.dismiss();
    }

    @Override
    public void OnRequestDetailSuccess(View view, Object data) {
//        RequestDetailModel temp=(RequestDetailModel) data;
//        Log.i("myVal", "Sent to "+temp.getSentTo());
//        Log.i("myVal", "date "+temp.getDate());
//        Log.i("myVal", "seen by "+temp.getSeenBy());
//        Log.i("myVal", "accp by "+temp.getAcceptedBy());
//        Log.i("myVal", "dnor "+temp.getDonorName());
//        Log.i("myVal", "bg "+temp.getBloodGroup());
//        Log.i("myVal", "cs "+temp.getCurrentStatus());
//        Log.i("myVal", "ti "+temp.getTime());
//        Log.i("myVal", "ty "+temp.getType());
        new DialogRequestDetail((RequestDetailModel) data, progress).show(getFragmentManager(),"request dialog");
        //progress.dismiss();
    }

    @Override
    public void OnAcceptDetailSuccess(View view, Object data) {
        new DialogAcceptDetail((AcceptDetailModel) data).show(getFragmentManager(),"request dialog");
        progress.dismiss();
    }

    @Override
    public void OnDonationDetailSuccess(View view, Object data) {
        new DialogDonationDetail((DonationDetailModel) data).show(getFragmentManager(),"request dialog");
        progress.dismiss();
    }

    @Override
    public void OnApiCallFail() {

    }

}
