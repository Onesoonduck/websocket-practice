package com.springv.elice_websocket.controller;

import com.springv.elice_websocket.chat.model.ChatCreateRequest;
import com.springv.elice_websocket.chat.model.ChatCreateResponse;
import com.springv.elice_websocket.chat.model.ChatInfoResponse;
import com.springv.elice_websocket.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/chat")
    public ChatCreateResponse makeChat(@RequestBody ChatCreateRequest request) {
        return chatService.makeChat(request.getChatUuid(), request.getChatTitle());
    }

    @GetMapping("/chats")
    public List<ChatInfoResponse> getChats() {
        return chatService.getChats();
    }
}
