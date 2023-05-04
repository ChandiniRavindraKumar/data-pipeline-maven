package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Payment;

import java.util.Optional;


public interface PaymentService {


    Iterable<Payment> findAll();

    Payment create(Payment payment);
    Optional<Payment> find(Integer paymentId);

    Payment update(Payment payment) throws Exception;
}
