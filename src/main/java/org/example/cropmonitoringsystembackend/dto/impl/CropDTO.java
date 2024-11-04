package org.example.cropmonitoringsystembackend.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.CropStatus;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO implements CropStatus {
    private String cropCode;
    private String cropCommonName;
    private String cropScientificName;
    private String category;
    private String cropSeason;
    private String cropImage;
    private String fieldCode;
}
