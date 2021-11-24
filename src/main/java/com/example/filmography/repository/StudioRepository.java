package com.example.filmography.repository;

import com.example.filmography.entity.Studio;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudioRepository extends CrudRepository<Studio, Long> {
    Optional<Studio> findByName(String name);

    boolean existsByNameAndCountry(String name, String country);
}
