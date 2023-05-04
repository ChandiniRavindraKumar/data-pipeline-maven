package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.City;

import java.util.Optional;


public interface CityService {


    Iterable<City> findAll();

    City create(City city);

    Optional<City> find(Integer cityId);

    City update(City city) throws Exception;
}
