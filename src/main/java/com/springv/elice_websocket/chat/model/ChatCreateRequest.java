package com.springv.elice_websocket.chat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatCreateRequest {
    private String chatUuid;
    private String chatTitle;

    public ChatCreateRequest(String chatUuid, String chatTitle) {
        this.chatUuid = chatUuid;
        this.chatTitle = chatTitle;
    }
}
