package org.example.delivermanagementsystem.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50)
    private String lastName;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10,15}", message = "Phone must be 10 to 15 digits")
    private String phone;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    private String gender;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;

    @NotBlank(message = "Street address is required")
    @Size(min = 5, max = 100)
    private String streetAddress;

    @NotBlank(message = "City is required")
    @Size(min = 2, max = 50)
    private String city;

    @NotBlank(message = "License number is required")
    @Size(min = 5, max = 20)
    private String licenseNumber;

    @NotBlank(message = "License state is required")
    @Size(min = 2, max = 50)
    private String licenseState;

    @NotNull(message = "License expiry date is required")
    private LocalDate licenseExpiry;

    @NotBlank(message = "License class is required")
    private String licenseClass;

    @NotBlank(message = "Experience is required")
    private String experience;

    @NotBlank(message = "Availability is required")
    private String availability;

    private String preferredArea;

    @AssertTrue(message = "You must agree to the terms")
    private boolean termsAgreement;

    private String rol = "DRIVER";

}
