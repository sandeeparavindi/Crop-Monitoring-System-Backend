package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.customObj.CropResponse;
import org.example.cropmonitoringsystembackend.dao.CropDAO;
import org.example.cropmonitoringsystembackend.dto.impl.CropDTO;
import org.example.cropmonitoringsystembackend.entity.impl.Crop;
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
    private final Mapping mapping;
    @Override
    public void saveCrop(CropDTO cropDTO) {
        Crop saveCrop = cropDAO.save(mapping.convertToCrop(cropDTO));
        try{
            if(saveCrop == null){
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
