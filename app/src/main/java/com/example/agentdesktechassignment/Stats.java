package com.example.agentdesktechassignment;

public class Stats {
    String rides;
    String free_rides;
    Credits credits;

    public String getRides() {
        return rides;
    }

    public String getFree_rides() {
        return free_rides;
    }

    public Credits getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "rides='" + rides + '\'' +
                ", free_rides='" + free_rides + '\'' +
                ", credits=" + credits +
                '}';
    }
}
