package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Film;
import team.project.datapipeline.postgres.service.FilmService;

import java.net.URI;

@RestController
@RequestMapping("/films")

public class FilmController {
    @Autowired
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;

    }

    @GetMapping
    public Iterable<Film> List() {
        return filmService.findAll();
    }

    @GetMapping("/{filmId}")
    public ResponseEntity<Film> get(@PathVariable("filmId") Integer filmId) {
        return filmService.find(filmId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film film,
                                       UriComponentsBuilder uriBuilder) {
        Film created = filmService.create(film);
        URI newFilmUri = uriBuilder.path("/films/{filmId}").build(created.getFilmId());
        return ResponseEntity.created(newFilmUri).body(created);

    }

    @PutMapping
    public ResponseEntity<Film> update(@RequestBody Film film,
                                        UriComponentsBuilder uriBuilder) throws Exception {
        Film created = filmService.update(film);
        URI newFilmUri = uriBuilder.path("/films/{filmId}").build(created.getFilmId());
        return ResponseEntity.created(newFilmUri).body(created);

    }

}
