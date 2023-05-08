package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Payment;
import team.project.datapipeline.postgres.service.PaymentService;

import java.net.URI;

@RestController
@RequestMapping("/payments")

public class PaymentController {
    @Autowired
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;

    }

    @GetMapping
    public Iterable<Payment> List() {
        return paymentService.findAll();
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> get(@PathVariable("paymentId") Integer paymentId) {
        return paymentService.find(paymentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment,
                                       UriComponentsBuilder uriBuilder) {
        Payment created = paymentService.create(payment);
        URI newPaymentUri = uriBuilder.path("/payments/{paymentId}").build(created.getPaymentId());
        return ResponseEntity.created(newPaymentUri).body(created);

    }

    @PutMapping
    public ResponseEntity<Payment> update(@RequestBody Payment payment,
                                        UriComponentsBuilder uriBuilder) throws Exception {
        Payment created = paymentService.update(payment);
        URI newPaymentUri = uriBuilder.path("/payments/{paymentId}").build(created.getPaymentId());
        return ResponseEntity.created(newPaymentUri).body(created);

    }

}
