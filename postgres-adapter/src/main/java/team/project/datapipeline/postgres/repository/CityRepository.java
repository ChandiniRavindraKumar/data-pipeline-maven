package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Address;
import team.project.datapipeline.postgres.model.City;

public interface CityRepository extends CrudRepository<City, Integer> {

}
