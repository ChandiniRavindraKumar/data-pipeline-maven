package team.project.datapipeline.postgres.service;


import team.project.datapipeline.postgres.model.FilmActor;

import java.util.Optional;


public interface FilmActorService {


    Iterable<FilmActor> findAll();

    FilmActor create(FilmActor filmActor);
    Optional<FilmActor> find(Integer filmId);

}
