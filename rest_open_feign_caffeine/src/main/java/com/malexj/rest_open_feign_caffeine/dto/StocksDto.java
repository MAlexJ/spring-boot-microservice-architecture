package com.malexj.rest_open_feign_caffeine.dto;

import com.malexj.rest_open_feign_caffeine.model.Stock;
import lombok.Value;

import java.util.List;

@Value
public class StocksDto {
    List<Stock> stocks;
}
