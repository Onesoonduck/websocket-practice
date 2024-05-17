package com.springv.elice_websocket.order.service;

import com.springv.elice_websocket.book.domain.Book;
import com.springv.elice_websocket.common.enums.ChatCode;
import com.springv.elice_websocket.common.enums.ErrorCode;
import com.springv.elice_websocket.common.event.AlarmEvent;
import com.springv.elice_websocket.common.exception.OutOfStockException;
import com.springv.elice_websocket.order.domain.Order;
import com.springv.elice_websocket.order.model.OrderRequest;
import com.springv.elice_websocket.order.model.OrderResponse;
import com.springv.elice_websocket.repository.book.BookRepository;
import com.springv.elice_websocket.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    // Spring applicationContext에 등록된 빈을 참조할 수 있는 인터페이스
    private final ApplicationEventPublisher eventPublisher; // 발행

    public OrderResponse saveOrder(OrderRequest orderRequest) {

        //책 조회
        Book book = bookRepository.findByBookCode(orderRequest.getBookCode());
        if (book == null) {
            throw new RuntimeException();
        }

        //재고 조회
        if (isStockInSufficient(orderRequest.getQuantity(), book.getQuantity())) {
            // 알림 전송 - 이벤트 드리븐 기반 프로그래밍
            eventPublisher.publishEvent(new AlarmEvent(ChatCode.ORDER_ISSUE.getChatUuid(), ErrorCode.OUT_OF_STOCK));
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
