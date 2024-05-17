package com.springv.elice_websocket.controller;

import com.springv.elice_websocket.chat.model.message.MessageModel;
import com.springv.elice_websocket.chat.model.message.OutputMessageModel;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {

    @MessageMapping("/message/send/{chatUuid}")
    @SendTo("/topic/chat/{chatUuid}")
    public OutputMessageModel sendMessage(@Payload MessageModel messageModel, @DestinationVariable String chatUuid) {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        // 불변 객체 - Builder, 팩토리 메서드 패턴, 생성자
        return new OutputMessageModel(messageModel.getSender(), messageModel.getChatUuid(),
            messageModel.getContent(), time, OutputMessageModel.MessageType.CHAT);
    }

}
