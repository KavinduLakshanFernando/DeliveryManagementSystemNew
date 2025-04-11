package org.example.delivermanagementsystem.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.delivermanagementsystem.entity.Driver;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private UUID vid;
    @NotBlank
    private String vehicleType;

    @NotBlank
    private String vehicleModel;

    @Min(1990)
    @Max(2030)
    private int vehicleYear;

    private String vehicleColor;

    @NotBlank
    private String licensePlate;

    @NotNull
    private LocalDate insuranceExpiry;

    @AssertTrue(message = "You must agree to the terms")
    private boolean termsAgreement;

    @ManyToOne
    private Driver driver;
}

