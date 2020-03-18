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

import com.fuuast.bds.Models.BDSApi;
import com.fuuast.bds.Models.HistoryModel;
import com.fuuast.bds.Models.NotificationModel;
import com.fuuast.bds.Models.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationsFragment extends Fragment {
    RecyclerView rv_notifications;
    List<NotificationModel> notifications;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_notifications = view.findViewById(R.id.rv_notifications);
        InitNotifications(view);
    }

    private void InitNotificationsView(View view, List<NotificationModel> list) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_notifications);
        NotificationsAdapter adapter = new NotificationsAdapter(this.getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
    }
    private void InitNotifications(final View view) {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://bds-be.syamonix.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);

        Call<ResponseModel<List<NotificationModel>>> call = bdsApi.getNotifications();

        call.enqueue(new Callback<ResponseModel<List<NotificationModel>>>() {
            @Override
            public void onResponse(Call<ResponseModel<List<NotificationModel>>> call, Response<ResponseModel<List<NotificationModel>>> response) {
                if(!response.isSuccessful()){
                    Log.i("mynotSuccessful", "my message"+response.message()+response.code());
                }
                ResponseModel<List<NotificationModel>> resp =response.body();

                List<NotificationModel> hist=resp.getData();
                Log.i("myok", "count "+hist.size());
                InitNotificationsView(view, hist);
            }

            @Override
            public void onFailure(Call<ResponseModel<List<NotificationModel>>> call, Throwable t) {
                Log.i("myErrorthis", t.getMessage());
            }
        });
    }
}
