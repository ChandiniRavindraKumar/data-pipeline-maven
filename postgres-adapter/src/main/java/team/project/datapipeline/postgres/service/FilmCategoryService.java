import team.project.datapipeline.postgres.model.FilmCategory;

import java.util.Optional;


public interface FilmCategoryService {


    Iterable<FilmCategory> findAll();

    FilmCategory create(FilmCategory filmCategory);
    Optional<FilmCategory> find(Integer filmCategoryId);

}
