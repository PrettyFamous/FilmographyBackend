package com.example.filmography.service;

import com.example.filmography.entity.Director;
import com.example.filmography.model.DirectorModel;

public interface DirectorService {
    Director getDirectorById(Long id);

    Iterable<Director> getDirectors();

    Director addDirector(DirectorModel directorModel);

    Director updateDirector(Director director);

    void deleteById(Long id);

}
