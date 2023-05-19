package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.project.datapipeline.postgres.model.Actor;



@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {


}
