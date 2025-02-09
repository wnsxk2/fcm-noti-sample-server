package com.wnsxk2.fcmnotisampleserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wnsxk2.fcmnotisampleserver.dto.NotificationDTO.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Notification REST - API 테스트")
@AutoConfigureMockMvc
@SpringBootTest
public class NotificationTest {

    @Autowired
    private MockMvc mvc;

    @DisplayName("[api] 알림 요청 ")
    @Test
    void requestNotification() throws Exception {

        Request request = Request.builder()
                .name("joontae")
                .region("saha")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(request);

        mvc.perform(post("/api/notification")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print());
    }
}
