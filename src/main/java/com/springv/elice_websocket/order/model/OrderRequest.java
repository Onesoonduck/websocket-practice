package com.springv.elice_websocket.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequest {
    private String bookCode;
    private String bookName;
    private long quantity;

    public OrderRequest(String bookCode, String bookName, long quantity) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.quantity = quantity;
    }
}
