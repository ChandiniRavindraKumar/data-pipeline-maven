package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Payment;
import team.project.datapipeline.postgres.model.Rental;

public interface RentalRepository extends CrudRepository<Rental, Integer> {

}
