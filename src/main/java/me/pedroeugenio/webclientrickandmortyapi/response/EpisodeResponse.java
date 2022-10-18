package me.pedroeugenio.webclientrickandmortyapi.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EpisodeResponse {
    private String id;
    private String name;
    @JsonProperty(value = "air_date")
    private String airDate;
    private String episode;
    private List<String> characters;
    private String url;
}
