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
    private String fieldCode;
    private String staffId;
    private String assignedRole;
    private String assignmentDate;
}
