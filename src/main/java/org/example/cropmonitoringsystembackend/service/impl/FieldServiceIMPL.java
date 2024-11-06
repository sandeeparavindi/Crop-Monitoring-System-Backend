package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dao.FieldDAO;
import org.example.cropmonitoringsystembackend.dto.impl.FieldDTO;
import org.example.cropmonitoringsystembackend.entity.impl.Field;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.FieldService;
import org.example.cropmonitoringsystembackend.util.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
