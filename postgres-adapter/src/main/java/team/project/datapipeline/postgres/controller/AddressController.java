package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.model.Address;
import team.project.datapipeline.postgres.service.AddressService;

import java.net.URI;

@RestController
@RequestMapping("/addresses")

public class AddressController {
    @Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;

    }

    @GetMapping
    public Iterable<Address> List() {
        return addressService.findAll();
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> get(@PathVariable("addressId") Integer addressId) {
        return addressService.find(addressId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address,
                                          UriComponentsBuilder uriBuilder) {
        Address created = addressService.create(address);
        URI newAddressUri = uriBuilder.path("/addresses/{addressId}").build(created.getAddressId());
        return ResponseEntity.created(newAddressUri).body(created);

    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address address,
                                        UriComponentsBuilder uriBuilder) throws Exception {
        Address created = addressService.update(address);
        URI newAddressUri = uriBuilder.path("/addresses/{addressId}").build(created.getAddressId());
        return ResponseEntity.created(newAddressUri).body(created);

    }

}
