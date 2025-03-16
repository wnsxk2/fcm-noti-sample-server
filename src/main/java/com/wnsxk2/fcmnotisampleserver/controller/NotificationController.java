package com.wnsxk2.fcmnotisampleserver.controller;

import com.wnsxk2.fcmnotisampleserver.dto.NotificationDTO.Response;
import com.wnsxk2.fcmnotisampleserver.dto.NotificationDTO.Request;
import com.wnsxk2.fcmnotisampleserver.dto.ResponseDTO;
import com.wnsxk2.fcmnotisampleserver.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class NotificationController extends AbstractController {

    private final NotificationService notificationService;

    @PostMapping("api/notification")
    public ResponseDTO<Response> sendNotification(@RequestBody Request request) {

        Response response = Response.builder()
                .title(request.getTitle())
                .message(request.getMessage())
                .build();

        notificationService.sendNotification(response);
        return ok();
    }

    @GetMapping("api/notification")
    public ResponseDTO<Response> getNotification() {
        return ok();
    }
}
