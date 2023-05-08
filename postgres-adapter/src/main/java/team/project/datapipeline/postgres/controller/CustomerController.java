package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.model.Customer;
import team.project.datapipeline.postgres.service.CustomerService;

import java.net.URI;

@RestController
@RequestMapping("/customers")

public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @GetMapping
    public Iterable<Customer> List() {
        return customerService.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> get(@PathVariable("customerId") Integer customerId) {
        return customerService.find(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer,
                                       UriComponentsBuilder uriBuilder) {
        Customer created = customerService.create(customer);
        URI newCustomerUri = uriBuilder.path("/customers/{customerId}").build(created.getCustomerId());
        return ResponseEntity.created(newCustomerUri).body(created);

    }

    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer,
                                        UriComponentsBuilder uriBuilder) throws Exception {
        Customer created = customerService.update(customer);
        URI newCustomerUri = uriBuilder.path("/customers/{customerId}").build(created.getCustomerId());
        return ResponseEntity.created(newCustomerUri).body(created);

    }

}
