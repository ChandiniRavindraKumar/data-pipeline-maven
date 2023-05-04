package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Language;

import java.util.Optional;


public interface LanguageService {


    Iterable<Language> findAll();

    Language create(Language language);
    Optional<Language> find(Integer languageId);

    Language update(Language language) throws Exception;
}
