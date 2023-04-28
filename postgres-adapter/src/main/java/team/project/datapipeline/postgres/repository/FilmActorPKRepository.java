package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.FilmActor;
import team.project.datapipeline.postgres.model.FilmActorPK;

public interface FilmActorPKRepository extends CrudRepository<FilmActorPK, Integer> {

}
