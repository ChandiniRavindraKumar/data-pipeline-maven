package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Store;

import java.util.Optional;


public interface StoreService {


    Iterable<Store> findAll();

    Store create(Store store);
    Optional<Store> find(Integer storeId);

}
