package org.example.cropmonitoringsystembackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.impl.VehicleDTO;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/vehicles")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class VehicleController {
    @Autowired
    private final VehicleService vehicleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        try {
            vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>("Vehicle saved successfully", HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>("Failed to save vehicle: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
