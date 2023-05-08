package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Store;
import team.project.datapipeline.postgres.service.StoreService;

import java.net.URI;

@RestController
@RequestMapping("/stores")

public class StoreController {
    @Autowired
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;

    }

    @GetMapping
    public Iterable<Store> List() {
        return storeService.findAll();
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<Store> get(@PathVariable("storeId") Integer storeId) {
        return storeService.find(storeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Store> create(@RequestBody Store store,
                                       UriComponentsBuilder uriBuilder) {
        Store created = storeService.create(store);
        URI newStoreUri = uriBuilder.path("/stores/{storeId}").build(created.getStoreId());
        return ResponseEntity.created(newStoreUri).body(created);

    }


}
