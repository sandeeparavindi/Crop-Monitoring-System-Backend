package org.example.cropmonitoringsystembackend.entity.impl;

import jakarta.persistence.*;
import lombok.*;
import org.example.cropmonitoringsystembackend.entity.SuperEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "field")
@Entity
@Table(name = "crops")
public class Crop implements SuperEntity {
    @Id
    private String cropCode;
    private String cropCommonName;
    private String cropScientificName;
    private String category;
    private String cropSeason;
    private String cropImage;
    @ManyToOne
    @JoinColumn(name = "fieldCode", nullable = false)
    private Field field;
}
