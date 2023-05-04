package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Rental;

import java.util.Optional;


public interface RentalService {


    Iterable<Rental> findAll();

    Rental create(Rental rental);
    Optional<Rental> find(Integer rentalId);

    Rental update(Rental rental) throws Exception;
}
