package com.example.filmography.controller;

import com.example.filmography.entity.Film;
import com.example.filmography.model.FilmModel;
import com.example.filmography.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        return new ResponseEntity<>(filmService.getFilmById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Film>> getFilms() {
        return new ResponseEntity<>(filmService.getFilms(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody FilmModel filmModel) {
        return new ResponseEntity<>(filmService.addFilm(filmModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Film> updateFilm(@RequestBody Film film) {
        return new ResponseEntity<>(filmService.updateFilm(film), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        filmService.deleteById(id);
    }
}
