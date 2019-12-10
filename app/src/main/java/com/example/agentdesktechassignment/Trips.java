package com.example.agentdesktechassignment;

public class Trips {
    String from ;
    String to;
    String from_time;
    String to_time;
    Cost cost;
    String trip_duration_in_mins;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getFrom_time() {
        return from_time;
    }

    public String getTo_time() {
        return to_time;
    }

    public Cost getCost() {
        return cost;
    }

    public String getTrip_duration_in_mins() {
        return trip_duration_in_mins;
    }

    @Override
    public String toString() {
        return "Trips{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", from_time='" + from_time + '\'' +
                ", to_time='" + to_time + '\'' +
                ", cost=" + cost +
                ", trip_duration_in_mins='" + trip_duration_in_mins + '\'' +
                '}';
    }
}
