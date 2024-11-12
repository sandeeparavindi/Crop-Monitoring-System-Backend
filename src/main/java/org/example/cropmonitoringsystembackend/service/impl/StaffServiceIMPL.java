package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dto.impl.StaffDTO;
import org.example.cropmonitoringsystembackend.service.StaffService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceIMPL implements StaffService {
    @Override
    public void saveStaff(StaffDTO staffDTO) {

    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return List.of();
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
