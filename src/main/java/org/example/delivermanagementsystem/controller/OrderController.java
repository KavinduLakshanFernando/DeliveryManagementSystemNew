package org.example.delivermanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.delivermanagementsystem.dto.PlaceOrderDTO;
import org.example.delivermanagementsystem.dto.ResponseDTO;
import org.example.delivermanagementsystem.service.PlaceOrderService;
import org.example.delivermanagementsystem.utill.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342/")
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final PlaceOrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveOrder(@RequestBody @Valid PlaceOrderDTO placeOrderDTO) {
        System.out.println(placeOrderDTO);
        try {
            int res = orderService.placeOrder(placeOrderDTO);
            if (res == VarList.Created) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new ResponseDTO(VarList.Created, "Success", placeOrderDTO));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                        .body(new ResponseDTO(VarList.Bad_Gateway, "Error", placeOrderDTO));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), placeOrderDTO));
        }
    }

}
