package com.example.filmography.controller;

import com.example.filmography.entity.Studio;
import com.example.filmography.model.StudioModel;
import com.example.filmography.service.StudioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/studios")
public class StudioController {

    private final StudioService studioService;

    @GetMapping("/{id}")
    public ResponseEntity<Studio> getStudioById(@PathVariable Long id) {
        return new ResponseEntity<>(studioService.getStudioById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Studio>> getStudios() {
        return new ResponseEntity<>(studioService.getStudios(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Studio> addStudio(@RequestBody StudioModel studioModel) {
        return new ResponseEntity<>(studioService.addStudio(studioModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Studio> updateStudio(@RequestBody Studio studio) {
        return new ResponseEntity<>(studioService.updateStudio(studio), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        studioService.deleteById(id);
    }
}
