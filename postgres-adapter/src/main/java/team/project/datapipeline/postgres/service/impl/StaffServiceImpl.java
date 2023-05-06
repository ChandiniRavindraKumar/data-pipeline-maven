package team.project.datapipeline.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.datapipeline.postgres.model.Address;
import team.project.datapipeline.postgres.model.Staff;
import team.project.datapipeline.postgres.repository.StaffRepository;
import team.project.datapipeline.postgres.service.StaffService;

import java.util.Objects;
import java.util.Optional;

@Service
class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Iterable<Staff> findAll() {
        return staffRepository.findAll();
    }
    @Override
    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Optional<Staff> find(Integer staffId) {
        return staffRepository.findById(staffId);
    }

    @Override
    public Staff update(Staff staff) throws Exception {

        if (Objects.isNull(staff.getStaffId())) {
            throw new Exception("Staff id is mandatory for the update operation");
        }

        Staff updatedStaff = null;

        Optional<Staff> existingStaffOpt = staffRepository.findById(staff.getStaffId());

        if (existingStaffOpt.isPresent()) {
            Staff existingStaff = existingStaffOpt.get();



            if (!staff.getFirstName().equals(existingStaff.getFirstName())) {
                existingStaff.setFirstName(staff.getFirstName());
            }

            if (!staff.getLastName().equals(existingStaff.getLastName())) {
                existingStaff.setLastName(staff.getLastName());
            }
            updatedStaff = staffRepository.save(existingStaff);
        } else {
            throw new Exception("Staff is not found in the database");
        }

        return updatedStaff;
    }
}
