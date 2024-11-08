package org.example.cropmonitoringsystembackend.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.FieldStaffAssignmentStatus;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldStaffAssignmentDTO implements FieldStaffAssignmentStatus {
    private Long id;
    private FieldDTO field;
    private StaffDTO staff;
    private String assignedRole;
    private String assignmentDate;
}
