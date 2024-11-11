package org.example.cropmonitoringsystembackend.dao;

import org.example.cropmonitoringsystembackend.entity.impl.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, String> {
    @Query("SELECT v FROM Vehicle v WHERE v.vehicleCode = :searchTerm OR v.licensePlateNumber = :searchTerm")
    List<Vehicle> findByVehicleCodeOrLicensePlate(@Param("searchTerm") String searchTerm);
}
