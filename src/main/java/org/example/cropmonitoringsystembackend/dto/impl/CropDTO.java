package org.example.cropmonitoringsystembackend.dto.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cropmonitoringsystembackend.customObj.CropResponse;
import org.example.cropmonitoringsystembackend.dto.CropStatus;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO implements CropStatus, CropResponse {
    @NotBlank(message = "Crop crop Cannot Be Null")
    private String cropCode;
    @NotBlank(message = "Crop Name Cannot Be Null")
    @Pattern(regexp = "^[A-Za-z0-9]", message = "Common Name not valid")
    private String cropCommonName;
    @NotBlank(message = "Crop Scientific Name Cannot Be Null")
    @Pattern(regexp = "^[A-Za-z0-9]", message = "Scientific Name not valid")
    private String cropScientificName;
    private String category;
    private String cropSeason;
    private String cropImage;
    private String fieldCode;
    private List<MonitoringLogDTO> monitoringLogList = new ArrayList<>();
}
