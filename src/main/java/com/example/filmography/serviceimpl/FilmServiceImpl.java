package com.example.filmography.serviceimpl;

import com.example.filmography.entity.Director;
import com.example.filmography.entity.Film;
import com.example.filmography.entity.Studio;
import com.example.filmography.exception.ResourceAlreadyExistsException;
import com.example.filmography.exception.ResourceNotFoundException;
import com.example.filmography.model.FilmModel;
import com.example.filmography.repository.DirectorRepository;
import com.example.filmography.repository.FilmRepository;
import com.example.filmography.repository.StudioRepository;
import com.example.filmography.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final DirectorRepository directorRepository;
    private final StudioRepository studioRepository;

    @Override
    public Film getFilmById(Long id) {
        return filmRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Film\" with id=" + id + " does not exist"
                ));
    }

    @Override
    public Iterable<Film> getFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film addFilm(FilmModel filmModel) {
        Director director = directorRepository
                .findById(filmModel.getDirectorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Director\" with id=" + filmModel.getDirectorId() + " does not exist."
                ));

        Studio studio = studioRepository
                .findById(filmModel.getStudioId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Studio\" with id=" + filmModel.getDirectorId() + " does not exist."));

        if (filmRepository
                .existsByFilmNameAndDirectorAndStudio(
                        filmModel.getFilmName(),
                        director,
                        studio
                )) {
            throw new ResourceAlreadyExistsException("The film with such name, director and studio already exists.");
        }
        Film film = new Film(filmModel.getFilmName(), filmModel.getCountry(), studio, director);
        filmRepository.save(film);

        return film;
    }

    @Override
    public Film updateFilm(Film film) {
        if ( !filmRepository.existsById(film.getId()) ) {
            throw new ResourceNotFoundException(
                    "Resource \"Film\" with id=" + film.getId() + " does not exist.");
        }
        filmRepository.save(film);
        return film;
    }

    @Override
    public void deleteById(Long id) {
        try {
            filmRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("The film with id " + id + " does not exist.", e);
        }
    }
}
