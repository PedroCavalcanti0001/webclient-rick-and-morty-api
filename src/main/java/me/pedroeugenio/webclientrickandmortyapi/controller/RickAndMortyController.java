package me.pedroeugenio.webclientrickandmortyapi.controller;

import lombok.AllArgsConstructor;
import me.pedroeugenio.webclientrickandmortyapi.client.RickAndMortyClient;
import me.pedroeugenio.webclientrickandmortyapi.response.CharacterResponse;
import me.pedroeugenio.webclientrickandmortyapi.response.EpisodeResponse;
import me.pedroeugenio.webclientrickandmortyapi.response.ListOfEpisodeResponse;
import me.pedroeugenio.webclientrickandmortyapi.response.LocationResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

    RickAndMortyClient rickAndMortyClient;

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
        return rickAndMortyClient.findAnCharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id){
        return rickAndMortyClient.findAnLocationById(id);
    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
        return rickAndMortyClient.findAnEpisodeById(id);
    }

    @GetMapping("/episode/")
    public Flux<ListOfEpisodeResponse> getAllEpisodes(){
        return rickAndMortyClient.getAllEpisodes();
    }
}


