package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Rental;
import team.project.datapipeline.postgres.service.RentalService;

import java.net.URI;

@RestController
@RequestMapping("/rentals")

public class RentalController {
    @Autowired
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;

    }

    @GetMapping
    public Iterable<Rental> List() {
        return rentalService.findAll();
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<Rental> get(@PathVariable("rentalId") Integer rentalId) {
        return rentalService.find(rentalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rental> create(@RequestBody Rental rental,
                                       UriComponentsBuilder uriBuilder) {
        Rental created = rentalService.create(rental);
        URI newRentalUri = uriBuilder.path("/rentals/{rentalId}").build(created.getRentalId());
        return ResponseEntity.created(newRentalUri).body(created);

    }


}
