package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Film;
import team.project.datapipeline.postgres.repository.FilmRepository;
import team.project.datapipeline.postgres.service.FilmService;

import java.util.Objects;
import java.util.Optional;

@Service
class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Iterable<Film> findAll() {
        return filmRepository.findAll();
    }
    @Override
    public Film create(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Optional<Film> find(Integer filmId) {
        return filmRepository.findById(filmId);
    }

    @Override
    public Film update(Film film) throws Exception {

        if (Objects.isNull(film.getFilmId())) {
            throw new Exception("Film id is mandatory for the update operation");
        }

        Film updatedFilm = null;

        Optional<Film> existingFilmOpt = filmRepository.findById(film.getFilmId());

        if (existingFilmOpt.isPresent()) {
            Film existingFilm = existingFilmOpt.get();

            if (!film.getRentalRate().equals(existingFilm.getRentalRate())) {
                existingFilm.setRentalRate(film.getRentalRate());
            }

            updatedFilm = filmRepository.save(existingFilm);
        } else {
            throw new Exception("Film is not found in the database");
        }

        return updatedFilm;
    }
}
