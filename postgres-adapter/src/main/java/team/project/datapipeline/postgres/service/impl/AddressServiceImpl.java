package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Address;
import team.project.datapipeline.postgres.model.Film;
import team.project.datapipeline.postgres.repository.AddressRepository;
import team.project.datapipeline.postgres.repository.FilmRepository;
import team.project.datapipeline.postgres.service.AddressService;
import team.project.datapipeline.postgres.service.FilmService;

import java.util.Objects;
import java.util.Optional;

@Service
class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> find(Integer addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public Address update(Address address) throws Exception {

        if (Objects.isNull(address.getAddressId())) {
            throw new Exception("Address id is mandatory for the update operation");
        }

        Address updatedAddress = null;

        Optional<Address> existingAddressOpt = addressRepository.findById(address.getAddressId());

        if (existingAddressOpt.isPresent()) {
            Address existingAddress = existingAddressOpt.get();

            if (!address.getPhone().equals(existingAddress.getPhone())) {
                existingAddress.setPhone(address.getPhone());
            }

            updatedAddress = addressRepository.save(existingAddress);
        } else {
            throw new Exception("Address is not found in the database");
        }

        return updatedAddress;
    }
}
