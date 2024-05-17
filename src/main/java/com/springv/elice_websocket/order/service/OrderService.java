package com.springv.elice_websocket.order.service;

import com.springv.elice_websocket.book.domain.Book;
import com.springv.elice_websocket.common.exception.OutOfStockException;
import com.springv.elice_websocket.order.domain.Order;
import com.springv.elice_websocket.order.model.OrderRequest;
import com.springv.elice_websocket.order.model.OrderResponse;
import com.springv.elice_websocket.repository.book.BookRepository;
import com.springv.elice_websocket.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    public OrderResponse saveOrder(OrderRequest orderRequest) {

        //책 조회
        Book book = bookRepository.findByBookCode(orderRequest.getBookCode());
        if (book == null) {
            throw new RuntimeException();
        }

        //재고 조회
        if (isStockInSufficient(orderRequest.getQuantity(), book.getQuantity())) {
            throw new OutOfStockException();
        }

        Order order = new Order(orderRequest.getBookCode(), orderRequest.getBookName(), orderRequest.getQuantity());
        orderRepository.save(order);

        return new OrderResponse(order.getUuid(), true);
    }

    private boolean isStockInSufficient(long orderQuantity, long bookQuantity) {
        return orderQuantity > bookQuantity;
    }
}
