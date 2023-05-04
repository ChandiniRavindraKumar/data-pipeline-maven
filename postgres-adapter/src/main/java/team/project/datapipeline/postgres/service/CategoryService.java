package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Address;
import team.project.datapipeline.postgres.model.Category;

import java.util.Optional;


public interface CategoryService {


    Iterable<Category> findAll();

    Category create(Category category);
    Optional<Category> find(Integer categoryId);

    Category update(Category category) throws Exception;
}
