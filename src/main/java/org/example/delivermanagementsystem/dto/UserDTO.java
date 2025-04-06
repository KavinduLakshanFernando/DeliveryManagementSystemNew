package org.example.delivermanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserDetails {
    private UUID uid;
   @NotBlank(message = "Required to fill name ")

    private String name;
    @NotBlank(message = "Required to fill Username ")

    private String username;
    @NotBlank(message = "Required to fill NIC ")

    private String nic;
    @NotBlank(message = "Required to fill Phone ")

    private String phone;
    @Email
    private String email;
    private String address;
    private String password;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
