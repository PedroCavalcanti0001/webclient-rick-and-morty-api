package me.pedroeugenio.webclientrickandmortyapi.client;

import lombok.extern.slf4j.Slf4j;
import me.pedroeugenio.webclientrickandmortyapi.response.CharacterResponse;
import me.pedroeugenio.webclientrickandmortyapi.response.EpisodeResponse;
import me.pedroeugenio.webclientrickandmortyapi.response.ListOfEpisodeResponse;
import me.pedroeugenio.webclientrickandmortyapi.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;

    @Autowired
    public RickAndMortyClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }


    public Mono<CharacterResponse> findAnCharacterById(String id){
        log.info("buscando o personagem com a id {{id}}", id);
        return webClient.get().uri("/character/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error ->
                        Mono.error(new RuntimeException("Verifique os parametros informados")))
                .bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findAnLocationById(String id){
        log.info("buscando o personagem com a id {{id}}", id);
        return webClient.get().uri("/location/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error ->
                        Mono.error(new RuntimeException("Verifique os parametros informados")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findAnEpisodeById(String id){
        log.info("buscando o personagem com a id {{id}}", id);
        return webClient.get().uri("/episode/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error ->
                        Mono.error(new RuntimeException("Verifique os parametros informados")))
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListOfEpisodeResponse> getAllEpisodes(){
        log.info("Listando todos os episodios");
        return webClient.get().uri("/episode/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error ->
                        Mono.error(new RuntimeException("Verifique os parametros informados")))
                .bodyToFlux(ListOfEpisodeResponse.class);
    }
}
