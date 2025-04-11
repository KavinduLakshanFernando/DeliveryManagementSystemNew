package org.example.delivermanagementsystem.service;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    int saveVehicle(@Valid VehicleDTO vehicleDTO);

    List<VehicleDTO> getAllVehicles();
}
