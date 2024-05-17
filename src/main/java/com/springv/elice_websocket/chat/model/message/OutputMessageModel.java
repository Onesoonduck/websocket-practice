package com.springv.elice_websocket.chat.model.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OutputMessageModel {

    private String sender;
    private String chatUuid;
    private String content;
    private String time;
    private MessageType type;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }
}
