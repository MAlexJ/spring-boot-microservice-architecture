package com.malexj.rest_open_feign_caffeine.service;

import com.malexj.rest_open_feign_caffeine.dto.StocksDto;
import com.malexj.rest_open_feign_caffeine.dto.TickersDto;

public interface BondsService {
    StocksDto getBondsFromMoex(TickersDto tickersDto);

}
