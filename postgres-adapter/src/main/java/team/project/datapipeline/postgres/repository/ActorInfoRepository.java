package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.ActorInfo;


public interface ActorInfoRepository extends CrudRepository<ActorInfo, Integer> {

}
