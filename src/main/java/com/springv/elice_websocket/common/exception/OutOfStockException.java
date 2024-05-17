package com.springv.elice_websocket.common.exception;

import com.springv.elice_websocket.common.enums.ErrorCode;

public class OutOfStockException extends RootException {

    public OutOfStockException(String message) {
        super(ErrorCode.OUT_OF_STOCK.getMessage());
    }

}
