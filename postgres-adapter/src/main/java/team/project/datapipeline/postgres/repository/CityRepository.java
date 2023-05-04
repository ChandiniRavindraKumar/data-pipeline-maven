package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.project.datapipeline.postgres.model.Address;
import team.project.datapipeline.postgres.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
