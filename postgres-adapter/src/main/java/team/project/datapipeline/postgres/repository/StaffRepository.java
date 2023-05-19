package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Rental;
import team.project.datapipeline.postgres.model.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer> {

}
