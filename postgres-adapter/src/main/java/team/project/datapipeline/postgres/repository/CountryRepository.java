package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.project.datapipeline.postgres.model.City;
import team.project.datapipeline.postgres.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

}
