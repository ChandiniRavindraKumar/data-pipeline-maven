package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.FilmCategory;
import team.project.datapipeline.postgres.repository.FilmCategoryRepository;
import team.project.datapipeline.postgres.service.FilmCategoryService;

import java.util.Optional;

@Service
class FilmCategoryServiceImpl implements FilmCategoryService {

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    @Override
    public Iterable<FilmCategory> findAll() {
        return filmCategoryRepository.findAll();
    }

    @Override
    public FilmCategory create(FilmCategory filmCategory) {
        return filmCategoryRepository.save(filmCategory);
    }

    @Override
    public Optional<FilmCategory> find(Integer categoryid) {
        return filmCategoryRepository.findById(categoryid);
    }

   }
