package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Address;
import team.project.datapipeline.postgres.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
