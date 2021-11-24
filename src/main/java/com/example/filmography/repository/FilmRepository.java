package com.example.filmography.repository;

import com.example.filmography.entity.Director;
import com.example.filmography.entity.Film;
import com.example.filmography.entity.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    Optional<Film> findByFilmName(String filmName);

    boolean existsByFilmNameAndDirectorAndStudio(String filmName, Director director, Studio studio);


}
