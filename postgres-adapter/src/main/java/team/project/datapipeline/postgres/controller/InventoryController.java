package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Inventory;
import team.project.datapipeline.postgres.service.InventoryService;

import java.net.URI;

@RestController
@RequestMapping("/inventories")

public class InventoryController {
    @Autowired
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;

    }

    @GetMapping
    public Iterable<Inventory> List() {
        return inventoryService.findAll();
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<Inventory> get(@PathVariable("inventoryId") Integer inventoryId) {
        return inventoryService.find(inventoryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventory> create(@RequestBody Inventory inventory,
                                          UriComponentsBuilder uriBuilder) {
        Inventory created = inventoryService.create(inventory);
        URI newInventoryUri = uriBuilder.path("/inventories/{inventoryId}").build(created.getInventoryId());
        return ResponseEntity.created(newInventoryUri).body(created);

    }

   }
