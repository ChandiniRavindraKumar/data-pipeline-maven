package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.project.datapipeline.postgres.model.Country;
import team.project.datapipeline.postgres.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
