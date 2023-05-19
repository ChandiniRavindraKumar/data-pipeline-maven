package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.City;
import team.project.datapipeline.postgres.model.FilmActor;
import team.project.datapipeline.postgres.service.CityService;
import team.project.datapipeline.postgres.service.FilmActorService;

import java.net.URI;

@RestController
@RequestMapping("/filmactors")

public class FilmActorController {
    @Autowired
    private final FilmActorService filmActorService;

    public FilmActorController(FilmActorService filmActorService) {
        this.filmActorService = filmActorService;

    }

    @GetMapping
    public Iterable<FilmActor> List() {
        return filmActorService.findAll();
    }

    @GetMapping("/{filmactorId}")
    public ResponseEntity<FilmActor> get(@PathVariable("filmActorId") Integer id) {
        return filmActorService.find(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FilmActor> create(@RequestBody FilmActor filmActor,
                                          UriComponentsBuilder uriBuilder) {
        FilmActor created = filmActorService.create(filmActor);
        URI newFilmActorUri = uriBuilder.path("/filmactors/{filmactorId}").build(created.getId());
        return ResponseEntity.created(newFilmActorUri).body(created);

    }

   }
