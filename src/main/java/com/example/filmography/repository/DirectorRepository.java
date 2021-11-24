package com.example.filmography.repository;

import com.example.filmography.entity.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository extends CrudRepository<Director, Long> {
    Optional<Director> findByFullName(String fullName);

    boolean existsByFullNameAndBirthDateAndCountry(String fullName, String birthDate, String country);
}
