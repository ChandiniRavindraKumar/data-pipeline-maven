package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.City;
import team.project.datapipeline.postgres.repository.CityRepository;
import team.project.datapipeline.postgres.service.CityService;

import java.util.Optional;

@Service
class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }
    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public Optional<City> find(Integer cityId) {
        return cityRepository.findById(cityId);
    }

   }
