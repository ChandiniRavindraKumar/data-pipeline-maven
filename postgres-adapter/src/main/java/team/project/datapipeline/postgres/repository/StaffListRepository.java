package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Staff;
import team.project.datapipeline.postgres.model.StaffList;

public interface StaffListRepository extends CrudRepository<StaffList, String> {

}
