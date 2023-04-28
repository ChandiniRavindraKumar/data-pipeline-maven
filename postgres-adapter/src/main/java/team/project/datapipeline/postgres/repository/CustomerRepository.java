package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Country;
import team.project.datapipeline.postgres.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
