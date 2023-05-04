package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Country;

import java.util.Optional;


public interface CountryService {


    Iterable<Country> findAll();

    Country create(Country country);

    Optional<Country> find(Integer countryId);

    Country update(Country country) throws Exception;
}
