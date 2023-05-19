package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.FilmActor;
import team.project.datapipeline.postgres.model.Store;
import team.project.datapipeline.postgres.repository.FilmActorRepository;
import team.project.datapipeline.postgres.repository.StoreRepository;
import team.project.datapipeline.postgres.service.FilmActorService;
import team.project.datapipeline.postgres.service.StoreService;

import java.util.Optional;

@Service
class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Iterable<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store create(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Optional<Store> find(Integer storeId) {
        return storeRepository.findById(storeId);
    }

   }
