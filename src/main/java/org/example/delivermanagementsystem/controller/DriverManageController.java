package org.example.delivermanagementsystem.controller;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.DriverDTO;
import org.example.delivermanagementsystem.dto.ResponseDTO;
import org.example.delivermanagementsystem.service.DriverService;
import org.example.delivermanagementsystem.utill.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:63342/")
@RestController
@RequestMapping("api/v1/driver")
public class DriverManageController {

    private final DriverService driverService;

    public DriverManageController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveDriver(@RequestBody @Valid DriverDTO driverDTO) {
        try {
            int res = driverService.saveDriver(driverDTO);
            switch (res) {
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", driverDTO));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
        }

    }
