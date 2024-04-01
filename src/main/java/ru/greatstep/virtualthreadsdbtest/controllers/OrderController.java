package ru.greatstep.virtualthreadsdbtest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.greatstep.virtualthreadsdbtest.models.dto.Response;
import ru.greatstep.virtualthreadsdbtest.service.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/getOrders")
    public ResponseEntity<Response> getOrders(@RequestParam("code") String clientCode) throws InterruptedException {
        return ResponseEntity.ok(orderService.findOrders(clientCode));
    }

}
