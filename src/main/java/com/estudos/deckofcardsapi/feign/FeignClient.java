package com.estudos.deckofcardsapi.feign;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Service
@org.springframework.cloud.openfeign.FeignClient(url = "https://deckofcardsapi.com/api/deck", name = "deckofcards")
public interface FeignClient {

    @GetMapping("/new/")
    Map<String, Object> novoBaralho();
}
