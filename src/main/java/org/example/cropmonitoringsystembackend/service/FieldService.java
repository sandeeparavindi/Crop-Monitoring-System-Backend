package org.example.cropmonitoringsystembackend.service;

import org.example.cropmonitoringsystembackend.customObj.FieldResponse;
import org.example.cropmonitoringsystembackend.dto.impl.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    FieldResponse getSelectedField(String fieldCode);
    List<FieldDTO> getAllFields();
    void deleteField(String fieldCode);
    void updateField(String fieldCode, FieldDTO fieldDTO);
}
