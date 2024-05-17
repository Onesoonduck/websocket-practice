package com.springv.elice_websocket.repository.order;

import com.springv.elice_websocket.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
