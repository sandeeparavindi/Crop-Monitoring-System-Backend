package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dao.StaffDAO;
import org.example.cropmonitoringsystembackend.dao.VehicleDAO;
import org.example.cropmonitoringsystembackend.dto.impl.StaffDTO;
import org.example.cropmonitoringsystembackend.entity.impl.Staff;
import org.example.cropmonitoringsystembackend.entity.impl.Vehicle;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.StaffService;
import org.example.cropmonitoringsystembackend.util.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceIMPL implements StaffService {
    private final StaffDAO staffDAO;
    private final VehicleDAO vehicleDAO;
    private final Mapping mapping;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
        Vehicle vehicle = vehicleDAO.findById(staffDTO.getVehicleCode())
                .orElseThrow(() -> new DataPersistException("Invalid Vehicle code"));
        Staff staff = mapping.convertToStaff(staffDTO);
        staff.setVehicle(vehicle);
        Staff savedStaff = staffDAO.save(staff);
        try {
            if (savedStaff == null) {
                throw new DataPersistException("Can't save Staff");
            }
        } catch (DataPersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        List<Staff> getAllStaff = staffDAO.findAll();
        return mapping.convertToStaffListDTO(getAllStaff);
    }

    @Override
    public void deleteStaff(String id) {

    }

    @Override
    public void updateStaff(String id, StaffDTO staffDTO) {

    }

    @Override
    public List<StaffDTO> searchStaff(String searchTerm) {
        return List.of();
    }
}
