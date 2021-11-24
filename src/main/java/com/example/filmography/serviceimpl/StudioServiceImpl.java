package com.example.filmography.serviceimpl;

import com.example.filmography.entity.Studio;
import com.example.filmography.exception.ResourceAlreadyExistsException;
import com.example.filmography.exception.ResourceNotFoundException;
import com.example.filmography.model.StudioModel;
import com.example.filmography.repository.StudioRepository;
import com.example.filmography.service.StudioService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudioServiceImpl implements StudioService {
    private final StudioRepository studioRepository;

    @Override
    public Studio getStudioById(Long id) {
        return studioRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Resource \"Studio\" with id=" + id + " does not exist"
                ));
    }

    @Override
    public Iterable<Studio> getStudios() {
        return studioRepository.findAll();
    }

    @Override
    public Studio addStudio(StudioModel studioModel) {

        if (studioRepository
                .existsByNameAndCountry(
                        studioModel.getName(),
                        studioModel.getCountry()
                )) {
            throw new ResourceAlreadyExistsException("The studio with such name and country already exists.");
        }
        Studio studio = new Studio(
                studioModel.getName(),
                studioModel.getCountry()
        );
        studioRepository.save(studio);

        return studio;
    }

    @Override
    public Studio updateStudio(Studio studio) {
        if ( !studioRepository.existsById(studio.getId())) {
            throw new ResourceNotFoundException(
                    "Resource \"Studio\" with id=" + studio.getId() + " does not exist.");
        }
        studioRepository.save(studio);
        return studio;
    }

    @Override
    public void deleteById(Long id) {
        try {
            studioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("The studio with id " + id + " does not exist.", e);
        }
    }
}