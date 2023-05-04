package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Staff;
import team.project.datapipeline.postgres.model.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {

}
