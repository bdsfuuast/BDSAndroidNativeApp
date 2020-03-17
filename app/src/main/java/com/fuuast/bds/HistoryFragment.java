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

import com.fuuast.bds.Models.AppDeserializer;
import com.fuuast.bds.Models.BDSApi;
import com.fuuast.bds.Models.HistoryModel;
import com.fuuast.bds.Models.Post;
import com.fuuast.bds.Models.ProfileModel;
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
        //InitHistory(view);
        test();
    }

    private void test() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ProfileModel.class, new AppDeserializer<ProfileModel>())
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://bds-be.syamonix.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);

        Call<ResponseModel> call = bdsApi.getProfile();

        call.enqueue(new Callback<ResponseModel> () {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel>  response) {
                if(!response.isSuccessful()){
                    Log.i("mynotSuccessful", "my message"+response.message()+response.code());
                }
                ResponseModel pm =response.body();
                ProfileModel p=(ProfileModel)pm.getData();
                Log.i("myOK","this: "+ pm.getCode());
                Log.i("myOK","this: "+ pm.getData());
                Log.i("myOK","this: "+ p.getFullName());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.i("myErrorthis", t.toString());
            }
        });
        //InitHistoryView(view);
    }

    private void InitHistoryView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_history);
        HistoryAdapter adapter = new HistoryAdapter(this.getContext(), history);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
    }

    private void InitHistory(View view) {
        Gson gson = new GsonBuilder()
                        .registerTypeAdapter(HistoryModel.class, new AppDeserializer<List<HistoryModel>>())
                        .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://bds-be.syamonix.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);
        Call<List<HistoryModel>> call = bdsApi.getHistory();
        call.enqueue(new Callback<List<HistoryModel>>() {
            @Override
            public void onResponse(Call<List<HistoryModel>> call, Response<List<HistoryModel>> response) {
                if(!response.isSuccessful()){
                    Log.i("mytag", response.message()+response.code());
                }
                history =response.body();
                Log.i("mytag", history.get(0).getDescription());
            }

            @Override
            public void onFailure(Call<List<HistoryModel>> call, Throwable t) {
                Log.i("myError", t.getLocalizedMessage());
            }
        });
        //InitHistoryView(view);
    }
}
