package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
