package com.example.filmography.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class DirectorModel {

    @JsonProperty(value = "fullName")
    private String fullName;

    @JsonProperty(value = "birthDate")
    private String birthDate;

    @JsonProperty(value = "country")
    private String country;

}
