package team.project.datapipeline.postgres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import team.project.datapipeline.postgres.model.Staff;
import team.project.datapipeline.postgres.service.StaffService;

import java.net.URI;

@RestController
@RequestMapping("/staffs")

public class StaffController {
    @Autowired
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;

    }

    @GetMapping
    public Iterable<Staff> List() {
        return staffService.findAll();
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<Staff> get(@PathVariable("paymentId") Integer paymentId) {
        return staffService.find(paymentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Staff> create(@RequestBody Staff staff,
                                       UriComponentsBuilder uriBuilder) {
        Staff created = staffService.create(staff);
        URI newStaffUri = uriBuilder.path("/staffs/{staffId}").build(created.getStaffId());
        return ResponseEntity.created(newStaffUri).body(created);

    }

    @PutMapping
    public ResponseEntity<Staff> update(@RequestBody Staff staff,
                                        UriComponentsBuilder uriBuilder) throws Exception {
        Staff created = staffService.update(staff);
        URI newStaffUri = uriBuilder.path("/staffs/{staffId}").build(created.getStaffId());
        return ResponseEntity.created(newStaffUri).body(created);

    }

}
