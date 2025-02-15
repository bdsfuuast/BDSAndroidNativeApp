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
import com.fuuast.bds.Models.BDSApiHelper;
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

public class NotificationsFragment extends Fragment implements NotificationsAdapter.OnNotificationListener, BDSApiHelper.OnApiCallFinish {
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
        new BDSApiHelper().getNotifications(view,this);
    }

    @Override
    public void onHistoryClick(int position) {
        Log.i("myClick", "position "+notifications.get(position).getBody());
    }

    @Override
    public void OnApiCallSuccess(View view, Object data) {
        notifications=(List<NotificationModel>)data;
        RecyclerView recyclerView = view.findViewById(R.id.rv_notifications);
        NotificationsAdapter adapter = new NotificationsAdapter(this.getContext(), notifications,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnApiCallFail() {

    }

}
