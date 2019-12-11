package com.example.agentdesktechassignment.Model;

public class RiderProfile {
    private String message;
    private String success;
    private Data data;

    public String getMessage() {
        return message;
    }

    public String getSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "RiderProfile{" +
                "message='" + message + '\'' +
                ", success='" + success + '\'' +
                ", data=" + data +
                '}';
    }
}
