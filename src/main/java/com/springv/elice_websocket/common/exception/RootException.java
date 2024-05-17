package com.springv.elice_websocket.common.exception;

import lombok.Getter;

@Getter
public class RootException extends RuntimeException {
    private String message;

    public RootException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
