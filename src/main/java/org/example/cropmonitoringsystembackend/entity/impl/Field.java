package org.example.cropmonitoringsystembackend.entity.impl;

import jakarta.persistence.*;
import lombok.*;
import org.example.cropmonitoringsystembackend.entity.SuperEntity;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"crops", "assignments"})
@Entity
@Table(name = "fields")
public class Field implements SuperEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private Double extentSize;
    private String fieldImage1;
    private String fieldImage2;
    @OneToMany(mappedBy = "field")
    private List<Crop> crops = new ArrayList<>();
    @OneToMany(mappedBy = "field", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FieldStaffAssignment> assignments = new ArrayList<>();
}
