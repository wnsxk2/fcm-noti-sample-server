package com.wnsxk2.fcmnotisampleserver.service;

import com.niamedtech.expo.exposerversdk.ExpoPushNotificationClient;
import com.niamedtech.expo.exposerversdk.request.PushNotification;
import com.niamedtech.expo.exposerversdk.response.TicketResponse;

import com.wnsxk2.fcmnotisampleserver.dto.NotificationDTO.Response;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    public void sendNotification(Response noti) {

        try{
            List<String> to = new ArrayList<>();
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 사용자 expoPushToken 추가
            to.add("ExponentPushToken[wWcXncMByZrSFC8eBodOh4]");

            ExpoPushNotificationClient client = ExpoPushNotificationClient
                    .builder()
                    .setHttpClient(httpClient)
                    .build();

            PushNotification pushNotification = new PushNotification();
            pushNotification.setTo(to);
            pushNotification.setTitle(noti.getTitle());
            pushNotification.setBody(noti.getMessage());

            List<PushNotification> notifications = new ArrayList<>();
            notifications.add(pushNotification);


            List<TicketResponse.Ticket> response =  client.sendPushNotifications(notifications);

            for (TicketResponse.Ticket ticket : response) {
                // OK on success, ERROR on error
                System.out.println(ticket.getId());
                System.out.println(ticket.getStatus());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
