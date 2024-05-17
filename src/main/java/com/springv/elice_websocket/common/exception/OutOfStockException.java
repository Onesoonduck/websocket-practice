package com.springv.elice_websocket.common.exception;

import com.springv.elice_websocket.common.enums.ErrorCode;
import lombok.Getter;

@Getter
public class OutOfStockException extends RootException {

    private ErrorCode errorCode;

    public OutOfStockException() {
        super(ErrorCode.OUT_OF_STOCK.getMessage());
    }

}
