package com.springbootnotificationfirebase.controller;

import com.springbootnotificationfirebase.config.FirebaseConfig;
import com.springbootnotificationfirebase.domain.MessageDTO;
import com.springbootnotificationfirebase.domain.SubscribeDTO;
import com.springbootnotificationfirebase.service.FirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class ExampleController {

    private final FirebaseService firebaseService;
    private final FirebaseConfig firebaseConfig;

    @GetMapping("/send")
    public void sendMessage() {
        firebaseService.sendPnsToTopic(MessageDTO.builder().body("test").title("test firebase").target("topic").build());
    }

    @PostMapping("/subscribe")
    public void subscribe() {
        firebaseConfig.subscribeToTopic(SubscribeDTO.builder().topicName("topic").tokens(List.of("token")).build());
    }
}
