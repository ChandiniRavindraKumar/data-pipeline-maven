package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Film;
import team.project.datapipeline.postgres.model.FilmActor;

public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {

}
