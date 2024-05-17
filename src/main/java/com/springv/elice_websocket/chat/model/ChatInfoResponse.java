package com.springv.elice_websocket.chat.model;

import lombok.Getter;

@Getter
public class ChatInfoResponse {
    private String chatUuid;
    private String chatTitle;

    public ChatInfoResponse(String chatUuid, String chatTitle) {
        this.chatUuid = chatUuid;
        this.chatTitle = chatTitle;
    }
}
