package com.project.shopapp.controllers;

import com.project.shopapp.dtos.OrderDetailDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.OrderDetail;
import com.project.shopapp.repositories.OrderDetailRepository;
import com.project.shopapp.services.OrderDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping
    public ResponseEntity<?> createOrderDetail (
            @Valid @RequestBody OrderDetailDTO newOrderDetail
    ){
        return ResponseEntity.ok(newOrderDetail);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail (@Valid @PathVariable("id") long id) throws DataNotFoundException {
        OrderDetail orderDetail = orderDetailService.getOrderDetail(id);
        return ResponseEntity.ok().body(orderDetail);
    }
    // Lay ra danh sach cac order_details cua 1 order nao do:
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderDetails(@Valid @PathVariable("orderId") long orderId) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(orderId);
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
