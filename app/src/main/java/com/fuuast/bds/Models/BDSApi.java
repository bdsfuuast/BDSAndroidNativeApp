package com.fuuast.bds.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BDSApi {
    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("notifications")
    Call<List<NotificationModel>> getNotifications();

    @Headers("authorization: 5DPtcqR1c0qAkvvw_5")
    @GET("history")
    Call<List<HistoryModel>> getHistory();

    @Headers("authorization: 5DPtcqR1c0qAkvvw_5")
    @GET("profile")
    Call<ResponseModel> getProfile();
}
