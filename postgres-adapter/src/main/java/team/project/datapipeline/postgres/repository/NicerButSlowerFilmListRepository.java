package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Language;
import team.project.datapipeline.postgres.model.NicerButSlowerFilmList;

public interface NicerButSlowerFilmListRepository extends CrudRepository<NicerButSlowerFilmList, String> {

}
