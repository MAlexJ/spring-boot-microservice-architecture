package com.malexj.rest_open_feign_caffeine.model;

public enum Currency {
    USD("USD"),
    EUR("EUR");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }
}
