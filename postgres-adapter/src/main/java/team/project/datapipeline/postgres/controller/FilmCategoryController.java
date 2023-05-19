package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.City;
import team.project.datapipeline.postgres.model.FilmCategory;
import team.project.datapipeline.postgres.service.CityService;
import team.project.datapipeline.postgres.service.FilmCategoryService;

import java.net.URI;

@RestController
@RequestMapping("/filmcategories")

public class FilmCategoryController {
    @Autowired
    private final FilmCategoryService filmCategoryService;

    public FilmCategoryController(FilmCategoryService filmCategoryService) {
        this.filmCategoryService = filmCategoryService;

    }

    @GetMapping
    public Iterable<FilmCategory> List() {
        return filmCategoryService.findAll();
    }

    @GetMapping("/{filmcategoryId}")
    public ResponseEntity<FilmCategory> get(@PathVariable("categoryid") Integer categoryid) {
        return filmCategoryService.find(categoryid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FilmCategory> create(@RequestBody FilmCategory filmCategory,
                                          UriComponentsBuilder uriBuilder) {
        FilmCategory created = filmCategoryService.create(filmCategory);
        URI newFilmCategoryUri = uriBuilder.path("/filmcategories/{categoryid}").build(created.getId());
        return ResponseEntity.created(newFilmCategoryUri).body(created);

    }

   }
