package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dao.VehicleDAO;
import org.example.cropmonitoringsystembackend.dto.impl.VehicleDTO;
import org.example.cropmonitoringsystembackend.entity.impl.Vehicle;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.VehicleService;
import org.example.cropmonitoringsystembackend.util.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceIMPL implements VehicleService {
    private final VehicleDAO vehicleDAO;
    private final Mapping mapping;
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        Vehicle savedVehicle = vehicleDAO.save(mapping.convertToVehicle(vehicleDTO));
        if (savedVehicle == null) {
            throw new DataPersistException("Can't save vehicle");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return List.of();
    }

    @Override
    public List<VehicleDTO> searchVehicles(String vehicleCode, String vehicleCategory) {
        return List.of();
    }

    @Override
    public void deleteVehicle(String vehicleCode) {

    }

    @Override
    public void updateVehicle(String vehicleCode, VehicleDTO vehicleDTO) {

    }
}
