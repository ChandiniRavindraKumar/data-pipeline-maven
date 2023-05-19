package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> findAll();

    Customer create(Customer customer);
    Optional<Customer> find(Integer customerId);

    Customer update(Customer customer) throws Exception;




}
