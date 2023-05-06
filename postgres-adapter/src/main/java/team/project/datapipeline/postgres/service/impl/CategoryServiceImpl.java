package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Category;
import team.project.datapipeline.postgres.repository.CategoryRepository;
import team.project.datapipeline.postgres.service.CategoryService;

import java.util.Optional;

@Service
class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> find(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }
    }
