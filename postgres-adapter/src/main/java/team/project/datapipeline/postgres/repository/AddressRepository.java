package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.project.datapipeline.postgres.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
