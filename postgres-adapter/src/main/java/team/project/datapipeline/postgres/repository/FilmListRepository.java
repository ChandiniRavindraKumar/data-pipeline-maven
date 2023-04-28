package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Film;
import team.project.datapipeline.postgres.model.FilmList;

public interface FilmListRepository extends CrudRepository<FilmList, String> {

}
