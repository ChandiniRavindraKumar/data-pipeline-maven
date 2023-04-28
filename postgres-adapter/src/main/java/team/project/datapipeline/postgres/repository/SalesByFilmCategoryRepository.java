package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Rental;
import team.project.datapipeline.postgres.model.SalesByFilmCategory;

public interface SalesByFilmCategoryRepository extends CrudRepository<SalesByFilmCategory, String> {

}
