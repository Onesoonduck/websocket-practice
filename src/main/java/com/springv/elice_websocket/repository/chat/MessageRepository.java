package com.springv.elice_websocket.repository.chat;

import com.springv.elice_websocket.chat.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
