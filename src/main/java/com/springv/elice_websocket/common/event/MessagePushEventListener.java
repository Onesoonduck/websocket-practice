package com.springv.elice_websocket.common.event;

import com.springv.elice_websocket.chat.model.message.MessageModel;
import com.springv.elice_websocket.chat.service.message.MessageService;
import com.springv.elice_websocket.common.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessagePushEventListener {

    private final MessageService messageService;

    // eventListener, alarmModel
    @EventListener
    public void eventListener(AlarmEvent event) {
        String chatUuid = event.getChatUuid();
        ErrorCode errorCode = (ErrorCode) event.getSource();

        // 목적 : 메세지를 채팅방에 전송
        // chatUuid : ChatCode.getChatUuid
        // 보내는 사람 : "재고 관리자"
        // content : errorCode.getDetailMessage
        String destination = "/topic/chat" + chatUuid;
        MessageModel messageModel = new MessageModel("재고 관리자",
            errorCode.getDetailMessage(), chatUuid);

        messageService.sendMessage(destination, messageModel);

    }
}
