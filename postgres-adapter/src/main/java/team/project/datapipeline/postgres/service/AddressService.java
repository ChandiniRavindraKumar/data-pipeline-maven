package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Actor;
import team.project.datapipeline.postgres.model.Address;

import java.util.Optional;

public interface AddressService {

    Iterable<Address> findAll();

    Address create(Address address);
    Optional<Address> find(Integer addressId);

    Address update(Address address) throws Exception;




}
