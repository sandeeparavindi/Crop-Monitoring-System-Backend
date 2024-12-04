package org.example.cropmonitoringsystembackend.dto.impl;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cropmonitoringsystembackend.customObj.MonitoringLogResponse;
import org.example.cropmonitoringsystembackend.dto.SuperDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonitoringLogDTO implements SuperDTO, MonitoringLogResponse {
    @NotBlank(message = "Monitoring log code Cannot Be Null")
    private String log_code;
    @NotBlank(message = "Monitoring log date Cannot Be Null")
    private String log_date;
    @NotBlank(message = "Monitoring log observation Cannot Be Null")
    private String Observation;
    private String log_image;
    private String fieldCode;
    private String cropCode;
    private String id;
}
