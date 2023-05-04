package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Inventory;

import java.util.Optional;


public interface InventoryService {


    Iterable<Inventory> findAll();

    Inventory create(Inventory inventory);

    Optional<Inventory> find(Integer inventoryId);

    Inventory update(Inventory inventory) throws Exception;
}
