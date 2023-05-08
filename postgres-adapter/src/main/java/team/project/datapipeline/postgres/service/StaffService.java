package team.project.datapipeline.postgres.service;

import team.project.datapipeline.postgres.model.Staff;

import java.util.Optional;

public interface StaffService {

    Iterable<Staff> findAll();

    Staff create(Staff staff);
    Optional<Staff> find(Integer staffId);

    Staff update(Staff staff) throws Exception;




}
