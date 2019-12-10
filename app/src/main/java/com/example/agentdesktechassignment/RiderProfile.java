package com.example.agentdesktechassignment;

public class RiderProfile {
    String message;
    String success;
    Data data;

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
