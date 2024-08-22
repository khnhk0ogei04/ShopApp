package com.project.shopapp.controllers;

import com.project.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    @PostMapping
    public ResponseEntity<?> createOrderDetail (
            @Valid @RequestBody OrderDetailDTO newOrderDetail
    ){
        return ResponseEntity.ok(newOrderDetail);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail (@Valid @PathVariable("id") long id) {
        return ResponseEntity.ok("getOrderDetail with Id " + id);
    }
    // Lay ra danh sach cac order_details cua 1 order nao do:
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderDetails(@Valid @PathVariable("orderId") long orderId) {
        return ResponseEntity.ok("getOrderDetails with orderId " + orderId);
    }
    // Sua doi 1 cai orderDetails nao do
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail (
            @Valid @PathVariable("id") long id,
            @RequestBody OrderDetailDTO newOrderDetailData
    ){
        return ResponseEntity.ok("Update OrderDetail with Id " + id + " to " + newOrderDetailData);
    }

    // Xoa 1 chi tiet don hang
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail (
            @Valid @PathVariable("id") long id
    ){
        return ResponseEntity.noContent().build();
    }
}
