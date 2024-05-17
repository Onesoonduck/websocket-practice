package com.springv.elice_websocket.common.exception;

import lombok.Getter;

@Getter
public class RootException extends RuntimeException {
    private String message;

    public RootException(String message) {
        super(message);
        this.message = message;
    }
}
