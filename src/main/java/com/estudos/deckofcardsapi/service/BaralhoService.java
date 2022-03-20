package com.estudos.deckofcardsapi.service;

import com.estudos.deckofcardsapi.feign.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BaralhoService {

    @Autowired
    FeignClient feignClient;

    public Map<String, Object> execute(){
        Map<String, Object> retornoApiExterna = feignClient.novoBaralho();
        return retornoApiExterna;
    }
}
