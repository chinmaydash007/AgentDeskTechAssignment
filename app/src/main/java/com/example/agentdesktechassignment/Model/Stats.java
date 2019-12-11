package com.example.agentdesktechassignment.Model;

public class Stats {
    private String rides;
    private String free_rides;
    private Credits credits;

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
