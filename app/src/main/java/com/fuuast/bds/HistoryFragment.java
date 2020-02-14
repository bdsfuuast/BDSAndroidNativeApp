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

import com.fuuast.bds.Models.HistoryModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment{
    RecyclerView rv_history;
    List<HistoryModel> history;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_history = view.findViewById(R.id.rv_history);
        InitHistory(view);
    }

    private void InitHistoryView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_history);
        HistoryAdapter adapter = new HistoryAdapter(this.getContext(), history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
    }

    private void InitHistory(View view) {
        history=new ArrayList<HistoryModel>();

        HistoryModel nm = new HistoryModel();
        nm.setDescription("You requested for A+ on 1/21/2020 at 12:16 AM");
        nm.setTitle("Accept");
        nm.setTime("3h ago");
        history.add(nm);

        HistoryModel  nm1 = new HistoryModel();
        nm1.setDescription("You requested for A+ on 1/21/2020 at 12:16 AM");
        nm1.setTitle("Accept");
        nm1.setTime("7h ago");
        history.add(nm1);

        HistoryModel nm2 = new HistoryModel();
        nm2.setDescription("You accepted a request for A+ blood on 1/21/2020 at 3:18 PM");
        nm2.setTitle("Accept");
        nm2.setTime("14h ago");
        history.add(nm2);

        InitHistoryView(view);
    }
}
