package com.malexj.rest_open_feign_caffeine.service.impl;

import com.malexj.rest_open_feign_caffeine.dto.StocksDto;
import com.malexj.rest_open_feign_caffeine.dto.TickersDto;
import com.malexj.rest_open_feign_caffeine.moexclient.CorporateBondsClient;
import com.malexj.rest_open_feign_caffeine.moexclient.GovBondsClient;
import com.malexj.rest_open_feign_caffeine.service.BondsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BondsServiceImpl implements BondsService {

    private final CorporateBondsClient corporateBondsClient;
    private final GovBondsClient govBondsClient;

    @Override
    public StocksDto getBondsFromMoex(TickersDto tickersDto) {
        return null;
    }
}
