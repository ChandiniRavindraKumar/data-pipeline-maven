package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Rental;
import team.project.datapipeline.postgres.repository.RentalRepository;
import team.project.datapipeline.postgres.service.RentalService;

import java.util.Optional;

@Service
class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Iterable<Rental> findAll() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental create(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public Optional<Rental> find(Integer rentalId) {
        return rentalRepository.findById(rentalId);
    }

   }
