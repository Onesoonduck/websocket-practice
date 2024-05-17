package com.springv.elice_websocket.chat.service.message;

import com.springv.elice_websocket.chat.domain.Chat;
import com.springv.elice_websocket.chat.domain.Message;
import com.springv.elice_websocket.chat.model.message.MessageModel;
import com.springv.elice_websocket.repository.chat.ChatRepository;
import com.springv.elice_websocket.repository.chat.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageChatService {
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;


    public void save(MessageModel messageModel) {
        String chatUuid = messageModel.getChatUuid();
        Chat chat = chatRepository.findByChatUuid(chatUuid);

        if (Objects.isNull(chat)) {
            throw new RuntimeException();
        }

        Message message = new Message(messageModel.getSender(), messageModel.getContent(), chat);
        messageRepository.save(message);

        log.info("{}가 전송한 '{}' 메시지가 저장되었습니다.", message.getSender(), message.getContent());
    }
}
