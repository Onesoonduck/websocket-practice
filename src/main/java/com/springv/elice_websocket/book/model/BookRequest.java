package com.springv.elice_websocket.book.model;

import lombok.Getter;

@Getter
public class BookRequest {
    private String bookName;
    private long quantity;

    public BookRequest(String bookName, long quantity) {
        this.bookName = bookName;
        this.quantity = quantity;
    }
}
