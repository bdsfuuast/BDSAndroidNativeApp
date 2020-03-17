package com.fuuast.bds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fuuast.bds.Models.NotificationModel;

import java.util.ArrayList;
import java.util.List;

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

    private void InitNotificationsView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_notifications);
        NotificationsAdapter adapter = new NotificationsAdapter(this.getContext(), notifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
    }

    private void InitNotifications(View view) {
        notifications=new ArrayList<NotificationModel>();
        NotificationModel nm = new NotificationModel();
        notifications.add(nm);

        NotificationModel  nm1 = new NotificationModel();
        notifications.add(nm1);

        NotificationModel nm2 = new NotificationModel();
        notifications.add(nm2);

        InitNotificationsView(view);
    }
}
