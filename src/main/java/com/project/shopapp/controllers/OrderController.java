package com.project.shopapp.controllers;


import com.project.shopapp.dtos.OrderDTO;
import com.project.shopapp.models.Order;
import com.project.shopapp.responses.OrderResponse;
import com.project.shopapp.services.IOrderService;
import com.project.shopapp.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
@RequiredArgsConstructor

public class OrderController {
    private final IOrderService orderService;
    @PostMapping("")
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderDTO orderDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(fieldError -> fieldError.getDefaultMessage())
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages.toString());
            }
            Order order = orderService.createOrder(orderDTO);
            return ResponseEntity.ok().body(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getOrders(@Valid @PathVariable long user_id) {
        try {
            return ResponseEntity.ok().body("Lay ra danh sach order tu user_id: " + user_id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@Valid @PathVariable long id, @RequestBody @Valid OrderDTO orderDTO){
        return ResponseEntity.ok().body("Cap nhat thanh cong 1 order");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@Valid @PathVariable long id) {
        return ResponseEntity.ok().body("Xoa thanh cong 1 order");
    }
}
