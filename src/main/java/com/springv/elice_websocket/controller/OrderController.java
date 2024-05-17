package com.springv.elice_websocket.controller;


import com.springv.elice_websocket.order.model.OrderRequest;
import com.springv.elice_websocket.order.model.OrderResponse;
import com.springv.elice_websocket.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class OrderController {

    private final OrderService orderService;

    /**
     * 입력 데이터 예시
     * OrderRequest orderRequest = new OrderRequest( "BOOK-001","엘리스 강의", 3);
     * @RequestBody : Java 객체로 conversion해줌.
     */
    @PostMapping("/order")
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.saveOrder(orderRequest);
    }
}
