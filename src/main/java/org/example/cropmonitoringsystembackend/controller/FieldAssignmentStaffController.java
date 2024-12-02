package org.example.cropmonitoringsystembackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.impl.FieldStaffAssignmentDTO;
import org.example.cropmonitoringsystembackend.service.FieldAssignmentStaffService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/assignment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FieldAssignmentStaffController {

    private final FieldAssignmentStaffService fieldAssignmentStaffService;

    @PostMapping("/save")
    public ResponseEntity<String> saveAssignment(@RequestBody FieldStaffAssignmentDTO assignmentDTO) {
        fieldAssignmentStaffService.saveAssignment(assignmentDTO);
        return ResponseEntity.ok("Assignment saved successfully");
    }

}
