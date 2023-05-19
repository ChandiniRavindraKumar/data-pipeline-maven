package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Inventory;
import team.project.datapipeline.postgres.model.Language;
import team.project.datapipeline.postgres.service.LanguageService;

import java.net.URI;

@RestController
@RequestMapping("/languages")

public class LanguageController {
    @Autowired
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;

    }

    @GetMapping
    public Iterable<Language> List() {
        return languageService.findAll();
    }

    @GetMapping("/{languageId}")
    public ResponseEntity<Language> get(@PathVariable("languageId") Integer languageId) {
        return languageService.find(languageId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Language> create(@RequestBody Language language,
                                          UriComponentsBuilder uriBuilder) {
        Language created = languageService.create(language);
        URI newLanguageUri = uriBuilder.path("/languages/{languageId}").build(created.getLanguageId());
        return ResponseEntity.created(newLanguageUri).body(created);

    }

   }
