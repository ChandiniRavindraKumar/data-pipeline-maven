package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Film;
import team.project.datapipeline.postgres.model.FilmCategory;

import java.util.Optional;

public interface FilmService {


    Iterable<Film> findAll();

    Film create(Film film);

    Optional<Film> find(Integer filmId);

    Film update(Film film) throws Exception;
}
