package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Customer;
import team.project.datapipeline.postgres.model.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {

}
