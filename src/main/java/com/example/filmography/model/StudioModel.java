package com.example.filmography.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class StudioModel {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "country")
    private String country;

}
