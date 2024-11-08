package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.customObj.FieldErrorResponse;
import org.example.cropmonitoringsystembackend.customObj.FieldResponse;
import org.example.cropmonitoringsystembackend.dao.FieldDAO;
import org.example.cropmonitoringsystembackend.dto.impl.FieldDTO;
import org.example.cropmonitoringsystembackend.entity.impl.Field;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.FieldService;
import org.example.cropmonitoringsystembackend.util.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FieldServiceIMPL implements FieldService {
    private final FieldDAO fieldDAO;
    private final Mapping mapping;
    @Override
    public void saveField(FieldDTO fieldDTO) {
        Field saveField = fieldDAO.save(mapping.convertToField(fieldDTO));
        try{
           if(saveField == null){
                throw new DataPersistException("Can't save field");
           }
        } catch (DataPersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FieldResponse getSelectedField(String fieldCode) {
        if(fieldDAO.existsById(fieldCode)){
            Field fields = fieldDAO.getReferenceById(fieldCode);
            return mapping.convertToFieldDTO(fields);
        } else {
            return new FieldErrorResponse(0, "Field not found");
        }
    }

    @Override
    public List<FieldDTO> getAllFields() {
        List<Field> getAllFields = fieldDAO.findAll();
        return mapping.convertToFieldListDTO(getAllFields);
    }

    @Override
    public void deleteField(String fieldCode) {

    }

    @Override
    public void updateField(String fieldCode, FieldDTO fieldDTO) {

    }
}
