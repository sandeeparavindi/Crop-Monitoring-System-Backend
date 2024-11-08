package org.example.cropmonitoringsystembackend.dao;

import org.example.cropmonitoringsystembackend.entity.impl.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropDAO extends JpaRepository<Crop, String> {
}
