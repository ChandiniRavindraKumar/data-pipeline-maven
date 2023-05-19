package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Country;
import team.project.datapipeline.postgres.repository.CountryRepository;
import team.project.datapipeline.postgres.service.CountryService;

import java.util.Optional;

@Service
class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }
    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> find(Integer countryId) {
        return countryRepository.findById(countryId);
    }

   }
