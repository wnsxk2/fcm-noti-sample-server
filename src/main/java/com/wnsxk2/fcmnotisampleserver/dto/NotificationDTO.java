package com.wnsxk2.fcmnotisampleserver.dto;

import lombok.*;

import java.io.Serializable;

public class NotificationDTO implements Serializable {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Request {
        private String name;
        private String region;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Response {
        private String name;
        private String region;
    }
}
