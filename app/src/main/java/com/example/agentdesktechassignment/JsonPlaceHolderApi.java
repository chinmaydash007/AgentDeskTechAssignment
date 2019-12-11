package com.example.agentdesktechassignment;

import com.example.agentdesktechassignment.Model.RiderProfile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET
    Call<RiderProfile> getProfile(@Url String url);


}
