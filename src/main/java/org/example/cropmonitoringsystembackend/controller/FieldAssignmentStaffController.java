package org.example.cropmonitoringsystembackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.impl.FieldStaffAssignmentDTO;
import org.example.cropmonitoringsystembackend.service.FieldAssignmentStaffService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/assignment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FieldAssignmentStaffController {

    private final FieldAssignmentStaffService fieldAssignmentStaffService;
    private static final Logger logger = LoggerFactory.getLogger(FieldAssignmentStaffController.class);

    @PreAuthorize("hasAnyRole('MANAGER')")
    @PostMapping("/save")
    public ResponseEntity<String> saveAssignment(@RequestBody FieldStaffAssignmentDTO assignmentDTO) {
        logger.info("Received request to save field staff assignment: {}", assignmentDTO);
        fieldAssignmentStaffService.saveAssignment(assignmentDTO);
        logger.info("Assignment saved successfully");
        return ResponseEntity.ok("Assignment saved successfully");
    }

    @GetMapping(value = "allassignments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldStaffAssignmentDTO> getAllAssignments() {
        logger.info("Fetching all field staff assignments");
        return fieldAssignmentStaffService.getAllFieldStaffAssignments();
    }
}
