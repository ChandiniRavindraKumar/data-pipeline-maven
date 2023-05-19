package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.City;
import team.project.datapipeline.postgres.model.Country;
import team.project.datapipeline.postgres.service.CityService;
import team.project.datapipeline.postgres.service.CountryService;

import java.net.URI;

@RestController
@RequestMapping("/countries")

public class CountryController {
    @Autowired
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;

    }

    @GetMapping
    public Iterable<Country> List() {
        return countryService.findAll();
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<Country> get(@PathVariable("countryId") Integer countryId) {
        return countryService.find(countryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country country,
                                          UriComponentsBuilder uriBuilder) {
        Country created = countryService.create(country);
        URI newCountryUri = uriBuilder.path("/countries/{countryId}").build(created.getCountryId());
        return ResponseEntity.created(newCountryUri).body(created);

    }

   }
