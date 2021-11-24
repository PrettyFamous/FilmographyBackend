package com.example.filmography.service;

import com.example.filmography.entity.Studio;
import com.example.filmography.model.StudioModel;

public interface StudioService {
    Studio getStudioById(Long id);

    Iterable<Studio> getStudios();

    Studio addStudio(StudioModel studioModel);

    Studio updateStudio(Studio director);

    void deleteById(Long id);
}
