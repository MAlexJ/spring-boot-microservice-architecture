package com.malexj.rest_open_feign_caffeine.controller;

import com.malexj.rest_open_feign_caffeine.dto.StocksDto;
import com.malexj.rest_open_feign_caffeine.dto.TickersDto;
import com.malexj.rest_open_feign_caffeine.service.BondsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bonds")
@AllArgsConstructor
public class MoexRestController {

    private final BondsService bondsService;

    @PostMapping("/getBondsByTickers")
    public StocksDto getBondsFromMoex(@RequestBody TickersDto tickersDto){
        return bondsService.getBondsFromMoex(tickersDto);

    }

}