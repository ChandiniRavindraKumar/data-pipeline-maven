package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Film;
import team.project.datapipeline.postgres.model.FilmCategory;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {

}
