package com.springv.elice_websocket.order.model;

import lombok.Getter;

@Getter
public class OrderResponse {
    private String orderUuid;
    private boolean success;

    public OrderResponse(String orderUuid, boolean success) {
        this.orderUuid = orderUuid;
        this.success = success;
    }
}
