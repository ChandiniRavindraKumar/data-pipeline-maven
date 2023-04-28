package team.project.datapipeline.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import team.project.datapipeline.postgres.model.Inventory;
import team.project.datapipeline.postgres.model.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer> {

}
