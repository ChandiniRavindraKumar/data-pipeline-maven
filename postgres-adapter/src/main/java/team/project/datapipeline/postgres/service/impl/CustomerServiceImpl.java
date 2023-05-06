package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.model.Address;
import team.project.datapipeline.postgres.model.Customer;
import team.project.datapipeline.postgres.repository.CustomerRepository;
import team.project.datapipeline.postgres.service.CustomerService;

import java.util.Objects;
import java.util.Optional;

@Service
class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> find(Integer customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer update(Customer customer) throws Exception {

        if (Objects.isNull(customer.getCustomerId())) {
            throw new Exception("Customer id is mandatory for the update operation");
        }

        Customer updatedCustomer = null;
        Customer staticCustomerId = new Customer();

        Optional<Customer> existingCustomerOpt = customerRepository.findById(staticCustomerId.getCustomerId());

        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();


            if (!customer.getFirstName().equals(existingCustomer.getFirstName())) {
                existingCustomer.setFirstName(customer.getFirstName());
            }

            if (!customer.getLastName().equals(existingCustomer.getLastName())) {
                existingCustomer.setLastName(customer.getLastName());
            }

            updatedCustomer = customerRepository.save(existingCustomer);
        } else {
            throw new Exception("Customer is not found in the database");
        }

        return updatedCustomer;
    }
}
