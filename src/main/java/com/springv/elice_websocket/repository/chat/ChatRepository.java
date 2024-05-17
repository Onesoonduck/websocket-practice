package com.springv.elice_websocket.repository.chat;

import com.springv.elice_websocket.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findByChatUuid(String chatUuid);
}
