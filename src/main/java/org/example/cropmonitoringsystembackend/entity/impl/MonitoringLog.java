package org.example.cropmonitoringsystembackend.entity.impl;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"field","crop","staff"})
@Entity
@Table(name = "monitoring_log")
public class MonitoringLog {
    @Id
    private String log_code;
    private Date log_date;
    private String Observation;
    @Column(columnDefinition = "LONGTEXT")
    private String log_image;
    @ManyToOne
    @JoinColumn(name = "fieldCode", nullable = false)
    private Field field;
    @ManyToOne
    @JoinColumn(name = "cropCode", nullable = false)
    private Crop crop;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Staff staff;
}
