package com.example.agentdesktechassignment;

public class Cost {
    String value;
    String currency;
    String currency_symbol;

    public String getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "value='" + value + '\'' +
                ", currency='" + currency + '\'' +
                ", currency_symbol='" + currency_symbol + '\'' +
                '}';
    }
}
