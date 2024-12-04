package org.example.cropmonitoringsystembackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.impl.StaffDTO;
import org.example.cropmonitoringsystembackend.exception.CropNotFoundException;
import org.example.cropmonitoringsystembackend.exception.DataPersistException;
import org.example.cropmonitoringsystembackend.exception.StaffMemberNotFoundException;
import org.example.cropmonitoringsystembackend.exception.VehicleNotFoundException;
import org.example.cropmonitoringsystembackend.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/staff")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StaffController {
    private final StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @PreAuthorize("hasAnyRole('MANAGER', 'ADMINISTRATIVE')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaffMember(@RequestBody StaffDTO staff) {
        if (staff == null){
            logger.warn("Attempted to save null StaffDTO");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                staffService.saveStaff(staff);
                logger.info("Successfully saved staff member: {}", staff);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistException e){
                logger.error("DataPersistException while saving staff member: {}", e.getMessage());
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                logger.error("Unexpected error while saving staff member", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping(value = "allstaff", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDTO> getAllStaffMember() {
        logger.info("Fetching all staff members");
        return staffService.getAllStaffs();
    }

    @PreAuthorize("hasAnyRole('MANAGER', 'ADMINISTRATIVE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSelectedMember(@PathVariable("id") String id) {
        logger.info("Deleting staff member with ID: {}", id);
        try {
            staffService.deleteStaff(id);
            logger.info("Successfully deleted staff member with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CropNotFoundException e) {
            logger.warn("Staff member with ID {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error while deleting staff member", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasAnyRole('MANAGER', 'ADMINISTRATIVE')")
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateSelectedMember(
            @PathVariable("id") String id,
            @RequestBody StaffDTO staffDTO
    ) {
        logger.info("Updating staff member with ID: {}", id);
        try {
            staffService.updateStaff(id, staffDTO);
            logger.info("Successfully updated staff member with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (VehicleNotFoundException e) {
            logger.warn("Vehicle for staff member with ID {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error while updating staff member", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<List<StaffDTO>> searchStaffMember(@RequestParam("searchTerm") String searchTerm) {
        logger.info("Searching staff members with search term: {}", searchTerm);
        List<StaffDTO> staffDTOS = staffService.searchStaff(searchTerm);
        return new ResponseEntity<>(staffDTOS, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('MANAGER', 'ADMINISTRATIVE')")
    @PatchMapping(value = "/{id}/return-vehicle")
    public ResponseEntity<Void> returnVehicle(@PathVariable("id") String staffId) {
        logger.info("Returning vehicle for staff member with ID: {}", staffId);
        try {
            staffService.returnVehicle(staffId);
            logger.info("Successfully returned vehicle for staff member with ID: {}", staffId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffMemberNotFoundException | VehicleNotFoundException e) {
            logger.warn("Error returning vehicle for staff member with ID: {}. Error: {}", staffId, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Unexpected error while returning vehicle", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
