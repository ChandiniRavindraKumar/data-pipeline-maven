package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
