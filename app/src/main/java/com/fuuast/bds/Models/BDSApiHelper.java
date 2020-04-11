package com.fuuast.bds.Models;

import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BDSApiHelper {
    String baseUrl;
    String token;
    public BDSApiHelper(){
        baseUrl="https://bds-be.syamonix.com/api/";
        token="5DPtcqR1c0qAkvvw_5";
    }
    public void getRequestDetail(final View view, final HistoryApiCallFinish onApiCallFinish, int Id){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);

        Call<ResponseModel<RequestDetailModel>> call = bdsApi.getRequestDetail(token,Id);

        call.enqueue(new Callback<ResponseModel<RequestDetailModel>>() {
            @Override
            public void onResponse(Call<ResponseModel<RequestDetailModel>> call, Response<ResponseModel<RequestDetailModel>> response) {
                if(!response.isSuccessful()){
                    Log.i("myNotSuccessful", "my message"+response.message()+response.code());
                }
                ResponseModel<RequestDetailModel> resp =response.body();

                RequestDetailModel data=resp.getData();
                onApiCallFinish.OnRequestDetailSuccess(view, data);
            }

            @Override
            public void onFailure(Call<ResponseModel<RequestDetailModel>> call, Throwable t) {
                Log.i("myError", t.getMessage());
            }
        });
    }

    public void getAcceptDetail(final View view, final HistoryApiCallFinish onApiCallFinish, int Id){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);

        Call<ResponseModel<AcceptDetailModel>> call = bdsApi.getAcceptDetail(token,Id);

        call.enqueue(new Callback<ResponseModel<AcceptDetailModel>>() {
            @Override
            public void onResponse(Call<ResponseModel<AcceptDetailModel>> call, Response<ResponseModel<AcceptDetailModel>> response) {
                if(!response.isSuccessful()){
                    Log.i("myNotSuccessful", "my message"+response.message()+response.code());
                }
                ResponseModel<AcceptDetailModel> resp =response.body();

                AcceptDetailModel data=resp.getData();
                onApiCallFinish.OnAcceptDetailSuccess(view, data);
            }

            @Override
            public void onFailure(Call<ResponseModel<AcceptDetailModel>> call, Throwable t) {
                Log.i("myError", t.getMessage());
            }
        });
    }

    public void getDonationDetail(final View view, final HistoryApiCallFinish onApiCallFinish, int Id){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);

        Call<ResponseModel<DonationDetailModel>> call = bdsApi.getDonationDetail(token,Id);

        call.enqueue(new Callback<ResponseModel<DonationDetailModel>>() {
            @Override
            public void onResponse(Call<ResponseModel<DonationDetailModel>> call, Response<ResponseModel<DonationDetailModel>> response) {
                if(!response.isSuccessful()){
                    Log.i("myNotSuccessful", "my message"+response.message()+response.code());
                }
                ResponseModel<DonationDetailModel> resp =response.body();

                DonationDetailModel data=resp.getData();
                onApiCallFinish.OnDonationDetailSuccess(view, data);
            }

            @Override
            public void onFailure(Call<ResponseModel<DonationDetailModel>> call, Throwable t) {
                Log.i("myError", t.getMessage());
            }
        });
    }

    public void getHistory(final View view, final HistoryApiCallFinish onApiCallFinish){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);

        Call<ResponseModel<List<HistoryModel>>> call = bdsApi.getHistory(token);

        call.enqueue(new Callback<ResponseModel<List<HistoryModel>>>() {
            @Override
            public void onResponse(Call<ResponseModel<List<HistoryModel>>> call, Response<ResponseModel<List<HistoryModel>>> response) {
                if(!response.isSuccessful()){
                    Log.i("mynotSuccessful", "my message"+response.message()+response.code());
                }
                ResponseModel<List<HistoryModel>> resp =response.body();

                List<HistoryModel> data=resp.getData();
                onApiCallFinish.OnHistorySuccess(view, data);
            }

            @Override
            public void onFailure(Call<ResponseModel<List<HistoryModel>>> call, Throwable t) {
                Log.i("myErrorthis", t.getMessage());
            }
        });
    }

    public void getNotifications(final View view, final OnApiCallFinish onApiCallFinish){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);

        Call<ResponseModel<List<NotificationModel>>> call = bdsApi.getNotifications(token);

        call.enqueue(new Callback<ResponseModel<List<NotificationModel>>>() {
            @Override
            public void onResponse(Call<ResponseModel<List<NotificationModel>>> call, Response<ResponseModel<List<NotificationModel>>> response) {
                if(!response.isSuccessful()){
                    Log.i("mynotSuccessful", "my message"+response.message()+response.code());
                }
                ResponseModel<List<NotificationModel>> resp =response.body();
                List<NotificationModel> data=resp.getData();

                onApiCallFinish.OnApiCallSuccess(view, data);
            }

            @Override
            public void onFailure(Call<ResponseModel<List<NotificationModel>>> call, Throwable t) {
                Log.i("myErrorthis", t.getMessage());
            }
        });
    }

    public void getProfile(final View view, final OnApiCallFinish onApiCallFinish){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BDSApi bdsApi=retrofit.create(BDSApi.class);

        Call<ResponseModel<ProfileModel>> call = bdsApi.getProfile(token);

        call.enqueue(new Callback<ResponseModel<ProfileModel>>() {
            @Override
            public void onResponse(Call<ResponseModel<ProfileModel>> call, Response<ResponseModel<ProfileModel>> response) {
                if(!response.isSuccessful()){
                    Log.i("mynotSuccessful", "my message"+response.message()+response.code());
                }
                ResponseModel<ProfileModel> resp =response.body();

                ProfileModel data=resp.getData();
                onApiCallFinish.OnApiCallSuccess(view,data);
            }

            @Override
            public void onFailure(Call<ResponseModel<ProfileModel>> call, Throwable t) {
                Log.i("myErrorthis", t.getMessage());
            }
        });
    }

    public interface OnApiCallFinish{
    void OnApiCallSuccess(View view, Object data);
    void OnApiCallFail();
    }

    public interface HistoryApiCallFinish{
        void OnHistorySuccess(View view,Object data);
        void OnRequestDetailSuccess(View view,Object data);
        void OnAcceptDetailSuccess(View view,Object data);
        void OnDonationDetailSuccess(View view,Object data);
        void OnApiCallFail();
    }
}
