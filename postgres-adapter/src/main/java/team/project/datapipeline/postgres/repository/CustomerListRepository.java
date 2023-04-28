package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Customer;
import team.project.datapipeline.postgres.model.CustomerList;

public interface CustomerListRepository extends CrudRepository<CustomerList, String> {

}
