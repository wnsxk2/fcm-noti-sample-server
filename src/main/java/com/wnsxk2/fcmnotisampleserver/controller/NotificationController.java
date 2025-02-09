package com.wnsxk2.fcmnotisampleserver.controller;

import com.wnsxk2.fcmnotisampleserver.dto.NotificationDTO.Response;
import com.wnsxk2.fcmnotisampleserver.dto.NotificationDTO.Request;
import com.wnsxk2.fcmnotisampleserver.dto.ResponseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class NotificationController extends AbstractController {

    @PostMapping("api/notification")
    public ResponseDTO<Response> sendNotification(@RequestBody Request request) {
        Response response = Response.builder()
                .name(request.getName())
                .region(request.getRegion())
                .build();
        return ok();
    }
}
