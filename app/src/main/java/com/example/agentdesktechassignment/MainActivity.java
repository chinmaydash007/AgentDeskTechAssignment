package com.example.agentdesktechassignment;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.agentdesktechassignment.Adapter.TripAdapter;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    Retrofit retrofit;
    private static final String TAG = "test";
    TripAdapter tripAdapter;
    RecyclerView trip_recyclerView;
    RiderProfile riderProfile;

    List<Trips> tripsList;
    Button reload_button;


    TextView person_name_tv, person_location_tv, person_t_rided_tv, person_freerides_tv, person_credit_tv;
    CircleImageView profile_image;

    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.include2);
        cardView.setBackgroundColor(Color.TRANSPARENT);


        person_name_tv = findViewById(R.id.person_name_tv);
        person_location_tv = findViewById(R.id.person_location_tv);
        person_t_rided_tv = findViewById(R.id.person_t_rided_tv);
        person_freerides_tv = findViewById(R.id.person_freerides_tv);
        person_credit_tv = findViewById(R.id.person_credit_tv);
        profile_image = findViewById(R.id.profile_image);
        trip_recyclerView = findViewById(R.id.past_trip_recyclerView);


        tripsList = new ArrayList<>();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        trip_recyclerView.setLayoutManager(linearLayoutManager);
        trip_recyclerView.setHasFixedSize(true);

        retrofit = new Retrofit.Builder().baseUrl("https://gist.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        fetchData();


    }

    private void fetchData() {

        final Call<RiderProfile> riderProfileCall = jsonPlaceHolderApi.getProfile("iranjith4/522d5b466560e91b8ebab54743f2d0fc/raw/7b108e4aaac287c6c3fdf93c3343dd1c62d24faf/radius-mobile-intern.json");
        riderProfileCall.enqueue(new Callback<RiderProfile>() {
            @Override
            public void onResponse(Call<RiderProfile> call, Response<RiderProfile> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, String.valueOf(response.code()));

                }
                riderProfile = response.body();

                if (riderProfile.message.equals("Success")) {
                    SetData();
                } else {
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.reload_dialog);
                    dialog.setCancelable(false);
                    reload_button = dialog.findViewById(R.id.reload);
                    reload_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            fetchData();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<RiderProfile> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }


    private void SetData() {
        for (Trips trips : riderProfile.getData().getTrips()) {
            tripsList.add(trips);
        }
        tripAdapter = new TripAdapter(tripsList, MainActivity.this);
        tripAdapter.notifyDataSetChanged();
        trip_recyclerView.setAdapter(tripAdapter);


        Data data = riderProfile.getData();
        Profile profile = data.getProfile();
        Stats stats = data.getStats();


        person_name_tv.setText(profile.getFirst_name() + " " + profile.getLast_name());
        person_location_tv.setText(profile.getCity() + ", " + profile.getCountry());
        person_t_rided_tv.setText(stats.rides);
        person_freerides_tv.setText(stats.free_rides);
        person_credit_tv.setText(stats.getCredits().getCurrency_symbol() + stats.getCredits().getValue());
        Glide.with(MainActivity.this).load(profile.middle_name).into(profile_image);
    }
}



