package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.FilmActor;
import team.project.datapipeline.postgres.repository.FilmActorRepository;
import team.project.datapipeline.postgres.service.FilmActorService;

import java.util.Optional;

@Service
class FilmActorServiceImpl implements FilmActorService {

    @Autowired
    private FilmActorRepository filmActorRepository;

    @Override
    public Iterable<FilmActor> findAll() {
        return filmActorRepository.findAll();
    }

    @Override
    public FilmActor create(FilmActor filmActor) {
        return filmActorRepository.save(filmActor);
    }

    @Override
    public Optional<FilmActor> find(Integer filmId) {
        return filmActorRepository.findById(filmId);
    }

   }
