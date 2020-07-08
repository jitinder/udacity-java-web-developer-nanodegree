package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> messageList;

    @PostConstruct
    public void postConstruct(){
        messageList = new ArrayList<>();
    }

    public void addNewMessage(ChatForm chatForm){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()){
            case 1: // Say
                chatMessage.setMessageText(chatForm.getMessageText());
                break;
            case 2: // Shout
                chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case 3: // Whisper
                chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messageList.add(chatMessage);
    }

    public List<ChatMessage> getMessageList() {
        return messageList;
    }

}
