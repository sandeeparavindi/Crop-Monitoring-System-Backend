package org.example.cropmonitoringsystembackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.impl.EquipmentDTO;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/equipment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EquipmentController {
    private final EquipmentService equipmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(@RequestBody EquipmentDTO equipment) {
        if (equipment == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            try {
                equipmentService.saveEquipment(equipment);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
