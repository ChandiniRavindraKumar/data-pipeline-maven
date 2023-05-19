package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.model.Film;

import java.util.Optional;

public interface FilmService {

    final Actor actor = null;


    Iterable<Film> findAll();

    Film create(Film film);

    Optional<Film> find(Integer filmId);

    Film update(Film film) throws Exception;

}
