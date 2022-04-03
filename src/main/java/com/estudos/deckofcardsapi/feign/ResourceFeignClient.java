package com.estudos.deckofcardsapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
@FeignClient(url = "https://deckofcardsapi.com/api/deck", name = "deckofcards")
public interface ResourceFeignClient {

    @GetMapping("/new/")
    Map<String, Object> novoBaralhoOrdenado();

    @GetMapping("/new/shuffle/?deck_count=1")
    Map<String, Object> novoBaralhoEmbaralhado();

    @GetMapping("/{deck_id}/draw/")
    Map<String, Object> tirarCarta(@PathVariable("deck_id") String deck_id, @RequestParam("count") String count);

    @GetMapping("/{deck_id}/shuffle/")
    Map<String, Object> reembaralhar(@PathVariable("deck_id") String deck_id);

    @GetMapping("/new/shuffle/?cards")
    Map<String, Object> novoBaralhoParcialEmbaralhado(@RequestParam("cards") String cards);

    @GetMapping("/{deck_id}/pile/{pile_name}/add/?cards")
    Map<String, Object> adicionarCartasPilha(@PathVariable("deck_id") String deck_id,@PathVariable("pile_name") String pile_name, @RequestParam("cards") String cards);
}
