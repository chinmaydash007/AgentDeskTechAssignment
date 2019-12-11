package com.example.agentdesktechassignment.Model;

public class Profile {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String profile_image;
    private String city;
    private String Country;

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return Country;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", profile_image='" + profile_image + '\'' +
                ", city='" + city + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
