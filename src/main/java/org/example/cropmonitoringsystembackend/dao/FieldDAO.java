package org.example.cropmonitoringsystembackend.dao;

import org.example.cropmonitoringsystembackend.entity.impl.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldDAO extends JpaRepository<Field, String> {
}
