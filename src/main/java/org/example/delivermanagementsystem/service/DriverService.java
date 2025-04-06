package org.example.delivermanagementsystem.service;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.DriverDTO;

public interface DriverService {
    int saveDriver(@Valid DriverDTO driverDTO);
}
