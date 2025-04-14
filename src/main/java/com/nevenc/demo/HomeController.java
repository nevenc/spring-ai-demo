package com.nevenc.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {

    private ChatClient chatClient;

    HomeController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping
    String home() {
        return chatClient
                .prompt()
                .user("who are you")
                .call()
                .content();
    }

}
