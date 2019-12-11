package com.example.agentdesktechassignment.Model;

import java.util.List;

public class Data {
    private Profile profile;
    private Stats stats;
    private List<Trips> trips;
    private Theme theme;

    public Profile getProfile() {
        return profile;
    }

    public Stats getStats() {
        return stats;
    }

    public List<Trips> getTrips() {
        return trips;
    }

    public Theme getTheme() {
        return theme;
    }
}
