package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Category;
import team.project.datapipeline.postgres.model.City;
import team.project.datapipeline.postgres.service.CityService;

import java.net.URI;

@RestController
@RequestMapping("/cities")

public class CityController {
    @Autowired
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;

    }

    @GetMapping
    public Iterable<City> List() {
        return cityService.findAll();
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<City> get(@PathVariable("cityId") Integer cityId) {
        return cityService.find(cityId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city,
                                          UriComponentsBuilder uriBuilder) {
        City created = cityService.create(city);
        URI newCityUri = uriBuilder.path("/cities/{cityId}").build(created.getCityId());
        return ResponseEntity.created(newCityUri).body(created);

    }

   }
