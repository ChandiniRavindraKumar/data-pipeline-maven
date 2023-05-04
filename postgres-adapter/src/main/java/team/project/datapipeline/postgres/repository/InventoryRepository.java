package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Film;
import team.project.datapipeline.postgres.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

}
