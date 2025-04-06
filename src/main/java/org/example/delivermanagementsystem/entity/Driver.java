package org.example.delivermanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid", columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID DID;

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "\\d{10,15}")
    private String phone;

    @NotNull
    private LocalDate dateOfBirth;

    private String gender;

    @NotBlank
    private String password;

    @NotBlank
    private String streetAddress;

    @NotBlank
    @Size(min = 2, max = 50)
    private String city;

    @NotBlank
    @Size(min = 5, max = 20)
    private String licenseNumber;

    @NotBlank
    @Size(min = 2, max = 50)
    private String licenseState;

    @NotNull
    private LocalDate licenseExpiry;

    @NotBlank
    private String licenseClass;

    @NotBlank
    private String experience;

    @NotBlank
    private String availability;

    private String preferredArea;

    private boolean termsAgreement;

    private String rol = "DRIVER";
    // Getters and setters
}
