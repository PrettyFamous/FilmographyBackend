package com.example.filmography.controller;

import com.example.filmography.entity.Director;
import com.example.filmography.model.DirectorModel;
import com.example.filmography.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        return new ResponseEntity<>(directorService.getDirectorById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Director>> getDirectors() {
        return new ResponseEntity<>(directorService.getDirectors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Director> addDirector(@RequestBody DirectorModel directorModel) {
        return new ResponseEntity<>(directorService.addDirector(directorModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Director> updateDirector(@RequestBody Director director) {
        return new ResponseEntity<>(directorService.updateDirector(director), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        directorService.deleteById(id);
    }
}
