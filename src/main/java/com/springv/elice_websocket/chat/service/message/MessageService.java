package com.springv.elice_websocket.chat.service.message;

import com.springv.elice_websocket.chat.model.message.MessageModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    // 메시지 전송을 위한 메서드
    public void sendMessage(String destination, MessageModel messageModel) {
        // 메시지 전송
        // D destination, Object payload
        try {
            simpMessagingTemplate.convertAndSend(destination, messageModel);
        } catch (MessagingException me) {
            // 로그 -> 예외
            log.error("주문 요청 시 발생한 에러, sender : {}", messageModel.getSender());

            throw new MessagingException("[Error] - sending message");
        }


    }

}
