package com.springv.elice_websocket.common.aspect;

import com.springv.elice_websocket.common.exception.OutOfStockException;
import com.springv.elice_websocket.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OutOfStockException.class)
    public ErrorResponse handleOutOfStockException(OutOfStockException e) {
        log.error("global handler - message = {}, status = {}", e.getMessage(), e.getErrorCode().getStatus());

        return new ErrorResponse(e.getErrorCode());
    }

}
