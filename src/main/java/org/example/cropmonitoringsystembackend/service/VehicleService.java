package org.example.cropmonitoringsystembackend.service;

import org.example.cropmonitoringsystembackend.dto.impl.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    List<VehicleDTO> searchVehicles(String vehicleCode, String vehicleCategory);
    void deleteVehicle(String vehicleCode);
    void updateVehicle(String vehicleCode, VehicleDTO vehicleDTO);
}
