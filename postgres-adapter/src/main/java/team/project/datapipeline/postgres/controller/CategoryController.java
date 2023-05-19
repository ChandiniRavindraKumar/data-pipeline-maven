package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Category;
import team.project.datapipeline.postgres.service.CategoryService;

import java.net.URI;

@RestController
@RequestMapping("/categories")

public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }

    @GetMapping
    public Iterable<Category> List() {
        return categoryService.findAll();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> get(@PathVariable("categoryId") Integer categoryId) {
        return categoryService.find(categoryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category,
                                          UriComponentsBuilder uriBuilder) {
        Category created = categoryService.create(category);
        URI newCategoryUri = uriBuilder.path("/categories/{categoryId}").build(created.getCategoryId());
        return ResponseEntity.created(newCategoryUri).body(created);

    }

   }
