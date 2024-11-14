package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dao.EquipmentDAO;
import org.example.cropmonitoringsystembackend.dao.FieldDAO;
import org.example.cropmonitoringsystembackend.dao.StaffDAO;
import org.example.cropmonitoringsystembackend.dto.impl.EquipmentDTO;
import org.example.cropmonitoringsystembackend.entity.impl.Equipment;
import org.example.cropmonitoringsystembackend.entity.impl.Field;
import org.example.cropmonitoringsystembackend.entity.impl.Staff;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.EquipmentService;
import org.example.cropmonitoringsystembackend.util.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentServiceIMPL implements EquipmentService {
    private final EquipmentDAO equipmentDAO;
    private final FieldDAO fieldDAO;
    private final StaffDAO staffDAO;
    private final Mapping mapping;

    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        Field field = fieldDAO.findById(equipmentDTO.getFieldCode())
                .orElseThrow(() -> new DataPersistException("Invalid Field code"));
        Staff staff = staffDAO.findById(equipmentDTO.getId())
                .orElseThrow(() -> new DataPersistException("Invalid Staff code"));

        Equipment equipment = mapping.convertToEquipment(equipmentDTO);

        equipment.setField(field);
        equipment.setStaff(staff);
        Equipment savedEquipment = equipmentDAO.save(equipment);
        try {
            if (savedEquipment == null) {
                throw new DataPersistException("Can't save Equipment");
            }
        } catch (DataPersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return List.of();
    }

    @Override
    public void deleteEquipment(String id) {

    }

    @Override
    public void updateEquipment(String id, EquipmentDTO equipmentDTO) {

    }

    @Override
    public List<EquipmentDTO> searchEquipment(String searchTerm) {
        return List.of();
    }
}
