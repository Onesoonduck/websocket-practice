package com.springv.elice_websocket.common.event;


// Spring 4.2 -> ApplicationEvent 상속X
public class AlarmEvent {
    private String chatUuid;
    private Object source;

    public AlarmEvent(String chatUuid, Object source) {
        this.chatUuid = chatUuid;
        this.source = source;
    }

}
