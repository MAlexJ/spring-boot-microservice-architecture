package com.malexj.rest_open_feign_caffeine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Stock {
    String ticker;
    String figi;
    String type;
    Currency currency;
    String source;
}
