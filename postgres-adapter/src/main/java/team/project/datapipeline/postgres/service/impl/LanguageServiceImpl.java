package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Inventory;
import team.project.datapipeline.postgres.model.Language;
import team.project.datapipeline.postgres.repository.InventoryRepository;
import team.project.datapipeline.postgres.repository.LanguageRepository;
import team.project.datapipeline.postgres.service.InventoryService;
import team.project.datapipeline.postgres.service.LanguageService;

import java.util.Optional;

@Service
class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Iterable<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language create(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Optional<Language> find(Integer languageId) {
        return languageRepository.findById(languageId);
    }

   }
