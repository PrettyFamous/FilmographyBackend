package com.example.filmography.service;

import com.example.filmography.entity.Film;
import com.example.filmography.model.FilmModel;

public interface FilmService {

    Film getFilmById(Long id);

    Iterable<Film> getFilms();

    Film addFilm(FilmModel filmModel);

    Film updateFilm(Film film);

    void deleteById(Long id);

}
