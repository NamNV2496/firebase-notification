package com.springbootnotificationfirebase.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.springbootnotificationfirebase.domain.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FirebaseService {

    public String sendPnsToDevice(MessageDTO messageDTO) {
        Message message = Message.builder()
                .setToken(messageDTO.getTarget())
                .setNotification(Notification.builder().setTitle(messageDTO.getTitle()).setBody(messageDTO.getTitle()).build())
                .putData("content", messageDTO.getTitle())
                .putData("body", messageDTO.getBody())
                .build();

        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            log.error("Fail to send firebase notification", e);
        }

        return response;
    }

    public String sendPnsToTopic(MessageDTO messageDTO) {
        Message message = Message.builder()
                .setTopic(messageDTO.getTarget())
                .setNotification(Notification.builder().setTitle(messageDTO.getTitle()).setBody(messageDTO.getTitle()).build())
                .putData("content", messageDTO.getTitle())
                .putData("body", messageDTO.getBody())
                .build();

        String response = null;
        try {
            FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            log.error("Fail to send firebase notification", e);
        }

        return response;
    }

}
