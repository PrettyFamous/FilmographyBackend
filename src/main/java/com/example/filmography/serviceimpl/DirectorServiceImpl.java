package com.example.filmography.serviceimpl;

import com.example.filmography.entity.Director;
import com.example.filmography.exception.ResourceAlreadyExistsException;
import com.example.filmography.exception.ResourceNotFoundException;
import com.example.filmography.model.DirectorModel;
import com.example.filmography.repository.DirectorRepository;
import com.example.filmography.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public Director getDirectorById(Long id) {
        return directorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Director\" with id=" + id + " does not exist"
                ));
    }

    @Override
    public Iterable<Director> getDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Director addDirector(DirectorModel directorModel) {

        if (directorRepository
                .existsByFullNameAndBirthDateAndCountry(
                        directorModel.getFullName(),
                        directorModel.getBirthDate(),
                        directorModel.getCountry()
                )) {
            throw new ResourceAlreadyExistsException("The director with such name, birth date and country already exists.");
        }
        Director director = new Director(
                directorModel.getFullName(),
                directorModel.getBirthDate(),
                directorModel.getCountry()
        );
        directorRepository.save(director);

        return director;
    }

    @Override
    public Director updateDirector(Director director) {
        if ( !directorRepository.existsById(director.getId())) {
            throw new ResourceNotFoundException(
                    "Resource \"Director\" with id=" + director.getId() + " does not exist.");
        }
        directorRepository.save(director);
        return director;
    }

    @Override
    public void deleteById(Long id) {
        try {
            directorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("The director with id " + id + " does not exist.", e);
        }
    }
}
