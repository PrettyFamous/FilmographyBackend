package com.example.filmography.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class FilmModel {
    @JsonProperty(value = "filmName")
    private String filmName;

    @JsonProperty(value = "country")
    private String country;

    @JsonProperty(value = "studioId")
    private Long studioId;

    @JsonProperty(value = "directorId")
    private Long directorId;
}
