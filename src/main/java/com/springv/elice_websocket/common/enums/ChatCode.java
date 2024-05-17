package com.springv.elice_websocket.common.enums;

import lombok.Getter;

@Getter
public enum ChatCode {

    ORDER_ISSUE("chat-001", "주문 이슈 처리방");
    private String chatUuid;
    private String title;

    ChatCode(String chatUuid, String title) {
        this.chatUuid = chatUuid;
        this.title = title;
    }
}
