package com.fuuast.bds.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface BDSApi {
    @GET("posts")
    Call<List<Post>> getPosts();

    //@Headers("authorization: 5DPtcqR1c0qAkvvw_5")
    @GET("notifications")
    Call<ResponseModel<List<NotificationModel>>> getNotifications(@Header("authorization") String authorization);

    @GET("requests")
    Call<ResponseModel<List<RequestModel>>> getRequests(@Header("authorization") String authorization);

    @GET("history")
    Call<ResponseModel<List<HistoryModel>>> getHistory(@Header("authorization") String authorization);

    @GET("profile")
    Call<ResponseModel<ProfileModel>> getProfile(@Header("authorization") String authorization);

    @GET("history?type=req")
    Call<ResponseModel<RequestDetailModel>> getRequestDetail(@Header("authorization") String authorization, @Query("id") int Id);

    @GET("history?type=acp")
    Call<ResponseModel<AcceptDetailModel>> getAcceptDetail(@Header("authorization") String authorization, @Query("id") int Id);

    @GET("history?type=don")
    Call<ResponseModel<DonationDetailModel>> getDonationDetail(@Header("authorization") String authorization, @Query("id") int Id);
}
