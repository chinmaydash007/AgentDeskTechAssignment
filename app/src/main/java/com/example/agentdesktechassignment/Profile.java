package com.example.agentdesktechassignment;

public class Profile {
    String first_name;
    String middle_name;
    String last_name;
    String profile_image;
    String city;
    String Country;

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
