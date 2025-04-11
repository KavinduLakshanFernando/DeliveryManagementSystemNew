package org.example.delivermanagementsystem.service;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.PlaceOrderDTO;

public interface PlaceOrderService {
    int placeOrder(@Valid PlaceOrderDTO placeOrderDTO);
}
