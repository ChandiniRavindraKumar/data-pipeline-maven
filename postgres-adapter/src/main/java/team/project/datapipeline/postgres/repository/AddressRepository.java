package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
