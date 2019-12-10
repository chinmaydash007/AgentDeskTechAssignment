package com.example.agentdesktechassignment.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agentdesktechassignment.R;
import com.example.agentdesktechassignment.Trips;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripDetailsViewHolder> {

    List<Trips> tripsList;
    Context context;

    public TripAdapter(List<Trips> tripsList, Context context) {
        this.tripsList = tripsList;
        this.context = context;
    }

    @NonNull
    @Override
    public TripDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_detail_single_layout, parent, false);
        Log.d("test", "onCreateViewHolder: ");
        return new TripDetailsViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull TripDetailsViewHolder holder, int position) {
        Trips trips = tripsList.get(position);
        holder.trip_from_textview.setText(trips.getFrom());
        holder.trip_to_textview.setText(trips.getTo());

        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, HH:mm", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        long millis_from = Long.parseLong(trips.getFrom_time()) * 1000;
        holder.trip_from_time_textview.setText(sdf.format(new Date(millis_from)));

        long millis_to = Long.parseLong(trips.getTo_time()) * 1000;
        holder.trip_to_time_textview.setText(sdf.format(new Date(millis_to)));


        String minutes = trips.getTrip_duration_in_mins();
        if (Long.parseLong(minutes) < 60) {
            String formatted = String.format("%02dmins", Duration.ofMinutes(Long.parseLong(minutes)).minusHours(Duration.ofMinutes(Long.parseLong(minutes)).toHours()).toMinutes());
            holder.trip_duration_textview.setText("Travel Time: " + formatted);
        } else {
            String formatted = String.format("%dhrs %02dmins", Duration.ofMinutes(Long.parseLong(minutes)).toHours(), Duration.ofMinutes(Long.parseLong(minutes)).minusHours(Duration.ofMinutes(Long.parseLong(minutes)).toHours()).toMinutes());
            holder.trip_duration_textview.setText("Travel Time: " + formatted);
        }

        holder.trip_cost_textview.setText(trips.getCost().getValue());
        holder.trip_currency_symbol_tv.setText(trips.getCost().getCurrency_symbol());

    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }

    class TripDetailsViewHolder extends RecyclerView.ViewHolder {
        TextView trip_from_textview;
        TextView trip_to_textview;
        TextView trip_from_time_textview;
        TextView trip_to_time_textview;
        TextView trip_duration_textview;
        TextView trip_cost_textview;
        TextView trip_currency_symbol_tv;

        public TripDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            trip_from_textview = itemView.findViewById(R.id.trip_from_textview);
            trip_to_textview = itemView.findViewById(R.id.trip_to_textview);
            trip_from_time_textview = itemView.findViewById(R.id.trip_from_tiime_textview);
            trip_to_time_textview = itemView.findViewById(R.id.trip_to_time_textview);
            trip_duration_textview = itemView.findViewById(R.id.trip_duration_textview);
            trip_cost_textview = itemView.findViewById(R.id.trip_cost_textview);
            trip_currency_symbol_tv = itemView.findViewById(R.id.trip_currency_symbol_tv);

        }
    }
}
