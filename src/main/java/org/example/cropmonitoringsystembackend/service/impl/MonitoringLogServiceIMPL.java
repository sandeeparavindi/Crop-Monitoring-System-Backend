package org.example.cropmonitoringsystembackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.cropmonitoringsystembackend.dao.CropDAO;
import org.example.cropmonitoringsystembackend.dao.FieldDAO;
import org.example.cropmonitoringsystembackend.dao.MonitoringLogDAO;
import org.example.cropmonitoringsystembackend.dao.StaffDAO;
import org.example.cropmonitoringsystembackend.dto.impl.MonitoringLogDTO;
import org.example.cropmonitoringsystembackend.entity.impl.Crop;
import org.example.cropmonitoringsystembackend.entity.impl.Field;
import org.example.cropmonitoringsystembackend.entity.impl.MonitoringLog;
import org.example.cropmonitoringsystembackend.entity.impl.Staff;
import org.example.cropmonitoringsystembackend.exception.*;
import org.example.cropmonitoringsystembackend.service.MonitoringLogService;
import org.example.cropmonitoringsystembackend.util.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MonitoringLogServiceIMPL implements MonitoringLogService {
    private final CropDAO cropDAO;
    private final FieldDAO fieldDAO;
    private final StaffDAO staffDAO;
    private final MonitoringLogDAO monitoringLogDAO;
    private final Mapping mapping;

    @Override
    public void saveMonitoringLog(MonitoringLogDTO monitoringLogDTO) {
        Field field = fieldDAO.findById(monitoringLogDTO.getFieldCode())
                .orElseThrow(() -> new DataPersistException("Invalid field code"));
        Crop crop = cropDAO.findById(monitoringLogDTO.getCropCode())
                .orElseThrow(() -> new DataPersistException("Invalid crop code"));
        Staff staff = staffDAO.findById(monitoringLogDTO.getId())
                .orElseThrow(() -> new DataPersistException("Invalid staff ID"));

        MonitoringLog log = mapping.convertToMonitoringLog(monitoringLogDTO);
        log.setField(field);
        log.setCrop(crop);
        log.setStaff(staff);

        MonitoringLog savedLog = monitoringLogDAO.save(log);
        if (savedLog == null) {
            throw new DataPersistException("Can't save Monitoring Log");
        }
    }


}
