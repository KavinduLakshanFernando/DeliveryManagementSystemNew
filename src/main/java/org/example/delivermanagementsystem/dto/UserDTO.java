package org.example.delivermanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.delivermanagementsystem.entity.StatusProfile;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private UUID uid;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private String password;


    private String role;

    private String Status;

    private String phone;


}
