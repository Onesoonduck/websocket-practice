package com.springv.elice_websocket.common.aspect;

import com.springv.elice_websocket.common.exception.OutOfStockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OutOfStockException.class)
    public void handleOutOfStockException(OutOfStockException e) {
        log.error("global handler - message = {}, status = {}", e.getMessage(), e.getErrorCode().getStatus());
    }



}
