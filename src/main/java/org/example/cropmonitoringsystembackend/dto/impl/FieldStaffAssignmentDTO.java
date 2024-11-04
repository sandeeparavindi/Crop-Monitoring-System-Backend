package org.example.cropmonitoringsystembackend.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.SuperDTO;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldStaffAssignmentDTO implements SuperDTO {
    private Long id;
    private FieldDTO field;
    private StaffDTO staff;
    private String assignedRole;
    private String assignmentDate;
}
