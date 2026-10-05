package com.substring.agent.backend.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;

    public String chat(String query, String conversationId) {
        // Use the chatClient to send the query and get a response
        return chatClient
                .prompt().user(query)
                .advisors(a ->

                a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .call().content();

    }

}
