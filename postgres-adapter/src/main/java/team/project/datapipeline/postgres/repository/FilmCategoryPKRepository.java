package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.FilmCategory;
import team.project.datapipeline.postgres.model.FilmCategoryPK;

public interface FilmCategoryPKRepository extends CrudRepository<FilmCategoryPK, Integer> {

}
