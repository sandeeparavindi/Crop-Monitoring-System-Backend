package org.example.cropmonitoringsystembackend.service;

import org.example.cropmonitoringsystembackend.customObj.CropResponse;
import org.example.cropmonitoringsystembackend.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    CropResponse getSelectedCrop(String cropCode);
    List<CropDTO> getAllCrops();
    void deleteCrop(String cropCode);
    void updateCrop(String cropCode, CropDTO cropDTO);
}
