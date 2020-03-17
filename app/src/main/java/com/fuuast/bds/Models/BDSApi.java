package com.fuuast.bds.Models;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BDSApi {
    @GET("posts")
    Call<List<Post>> getPosts();
}
