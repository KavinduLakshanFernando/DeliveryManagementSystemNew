package org.example.delivermanagementsystem.controller;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.CustomerDTO;
import org.example.delivermanagementsystem.dto.DriverDTO;
import org.example.delivermanagementsystem.dto.ResponseDTO;
import org.example.delivermanagementsystem.service.CustomerService;
import org.example.delivermanagementsystem.utill.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342/")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        try {
            int res = customerService.saveCustomer(customerDTO);
            switch (res) {
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", customerDTO));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), customerDTO));
        }
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        try {
            List<CustomerDTO> customers = customerService.getAllCustomers();
            if (customers.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
