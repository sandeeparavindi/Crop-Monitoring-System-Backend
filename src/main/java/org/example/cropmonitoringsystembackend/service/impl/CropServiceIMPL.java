package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.customObj.CropResponse;
import org.example.cropmonitoringsystembackend.dao.CropDAO;
import org.example.cropmonitoringsystembackend.dao.FieldDAO;
import org.example.cropmonitoringsystembackend.dto.impl.CropDTO;
import org.example.cropmonitoringsystembackend.entity.impl.Crop;
import org.example.cropmonitoringsystembackend.entity.impl.Field;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.CropService;
import org.example.cropmonitoringsystembackend.util.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CropServiceIMPL implements CropService {
    private final CropDAO cropDAO;
    private final FieldDAO fieldDAO;
    private final Mapping mapping;
    @Override
    public void saveCrop(CropDTO cropDTO) {
        Field field = fieldDAO.findById(cropDTO.getFieldCode())
                .orElseThrow(() -> new DataPersistException("Invalid field code"));
        Crop crop = mapping.convertToCrop(cropDTO);
        crop.setField(field);
        Crop savedCrop = cropDAO.save(crop);
        try {
            if (savedCrop == null) {
                throw new DataPersistException("Can't save Crop");
            }
        } catch (DataPersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CropResponse getSelectedCrop(String cropCode) {
        return null;
    }

    @Override
    public List<CropDTO> getAllCrops() {
        return List.of();
    }

    @Override
    public void deleteCrop(String cropCode) {

    }

    @Override
    public void updateCrop(String cropCode, CropDTO cropDTO) {

    }
}
