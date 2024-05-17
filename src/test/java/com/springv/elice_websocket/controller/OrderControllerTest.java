package com.springv.elice_websocket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springv.elice_websocket.order.model.OrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void throw_runtime_exception_when_save_order() throws Exception {
        OrderRequest orderRequest = new OrderRequest("BOOK-ABC", "엘리스" , 10);

        MvcResult mvcResult = mockMvc.perform(post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderRequest)))
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        assertThat(result).contains("에러 발생");
    }

    @Test
    public void unexpected_throw_when_save_order() {
        OrderRequest orderRequest = new OrderRequest("BOOK-ABC", "엘리스", 10);
        assertThatThrownBy(() -> mockMvc.perform(post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderRequest))))
                .hasCause(new RuntimeException());
    }
}