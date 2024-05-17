package com.springv.elice_websocket.common.response;

import com.springv.elice_websocket.common.enums.ErrorCode;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private int status;
    private String message;
    private String detailMessage;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.detailMessage = errorCode.getDetailMessage();
    }
}
