package com.example.agentdesktechassignment;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.agentdesktechassignment.Model.RiderProfile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";
    MutableLiveData<RiderProfile> riderProfile;

    public MutableLiveData<RiderProfile> getRiderProfile(JsonPlaceHolderApi jsonPlaceHolderApi) {
        if (riderProfile == null) {
            riderProfile = new MutableLiveData<>();
            fetchDataFromServer(jsonPlaceHolderApi);
        }
        return riderProfile;
    }

    private void fetchDataFromServer(JsonPlaceHolderApi jsonPlaceHolderApi) {
        final Call<RiderProfile> riderProfileCall = jsonPlaceHolderApi.getProfile("iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/radius-mobile-intern.json");
        riderProfileCall.enqueue(new Callback<RiderProfile>() {
            @Override
            public void onResponse(Call<RiderProfile> call, Response<RiderProfile> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, String.valueOf(response.code()));
                }
                riderProfile.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RiderProfile> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
