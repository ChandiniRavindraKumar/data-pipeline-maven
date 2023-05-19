package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.City;
import team.project.datapipeline.postgres.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
