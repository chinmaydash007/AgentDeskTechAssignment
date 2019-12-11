package com.example.agentdesktechassignment;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.agentdesktechassignment.Adapter.TripAdapter;
import com.example.agentdesktechassignment.Model.Data;
import com.example.agentdesktechassignment.Model.Profile;
import com.example.agentdesktechassignment.Model.RiderProfile;
import com.example.agentdesktechassignment.Model.Stats;
import com.example.agentdesktechassignment.Model.Trips;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    Retrofit retrofit;
    private static final String TAG = "test";
    TripAdapter tripAdapter;
    RecyclerView trip_recyclerView;
    LiveData<RiderProfile> riderProfile;

    List<Trips> tripsList;


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

        MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        trip_recyclerView.setLayoutManager(linearLayoutManager);
        trip_recyclerView.setHasFixedSize(true);

        retrofit = new Retrofit.Builder().baseUrl("https://gist.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        fetchData(jsonPlaceHolderApi, model);


    }

    private void fetchData(JsonPlaceHolderApi jsonPlaceHolderApi, MainActivityViewModel model) {
        riderProfile = model.getRiderProfile(jsonPlaceHolderApi);
        riderProfile.observe(this, new Observer<RiderProfile>() {
            @Override
            public void onChanged(RiderProfile riderProfile) {
                SetData(riderProfile);

            }
        });

    }


    private void SetData(RiderProfile riderProfile) {
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
        person_t_rided_tv.setText(stats.getRides());
        person_freerides_tv.setText(stats.getFree_rides());
        person_credit_tv.setText(stats.getCredits().getCurrency_symbol() + stats.getCredits().getValue());
        Glide.with(MainActivity.this).load(profile.getMiddle_name()).into(profile_image);
    }
}



