package com.springv.elice_websocket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springv.elice_websocket.book.model.BookRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //Mock 테스트시 필요한 의존성을 제공받기 위해
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc; //인텔리버전문제로 에러처럼 보임

    @Autowired
    private ObjectMapper objectMapper; //json -> java object

    @Test
    public void save_book_test () throws Exception {
        BookRequest bookRequest = new BookRequest("책 이름", 10);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookRequest)))
                .andExpect(status().isOk());
    }
}