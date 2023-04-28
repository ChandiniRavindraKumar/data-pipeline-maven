package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.SalesByFilmCategory;
import team.project.datapipeline.postgres.model.SalesByStore;

public interface SalesByStoreRepository extends CrudRepository<SalesByStore, String> {

}
