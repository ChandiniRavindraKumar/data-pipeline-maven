package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Inventory;
import team.project.datapipeline.postgres.repository.InventoryRepository;
import team.project.datapipeline.postgres.service.InventoryService;

import java.util.Optional;

@Service
class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Iterable<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Optional<Inventory> find(Integer inventoryId) {
        return inventoryRepository.findById(inventoryId);
    }

   }
