package com.springv.elice_websocket.common.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {

    OUT_OF_STOCK(400, "재고 부족.", "재고가 부족하여 주문이 어렵습니다.");

    private final int status;
    private final String message;
    private final String detailMessage;

    ErrorCode(int status, String message, String detailMessage) {
        this.status = status;
        this.message = message;
        this.detailMessage = detailMessage;
    }
}
