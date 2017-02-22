package ru.chat.chatdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.chat.chatdemo.model.Chat;
import ru.chat.chatdemo.model.Message;
import ru.chat.chatdemo.model.repositories.MessageRepository;

import java.util.*;

/**
 * Created by alexpench on 19.02.17.
 */
@Component
public class MessageServiceImpl implements MessageService {
    private List<Message> messages = new LinkedList<>();

    @Autowired
    private MessageRepository mRepo;

    @Override
    public List<Message> getMessagesForChat(Chat chat) {
        if (messages.isEmpty()) {
            populateAllMessages();
        }

        List<Message> chatMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getChatId() == chat.getId()) {
                chatMessages.add(message);
            }
        }
        if(chatMessages.isEmpty()){
            //if no messages found for chat, then create dummy, this is workaround to pass chatId to client
            chatMessages.add(new Message(999L, chat.getId(), "--", new Date(System.currentTimeMillis()) ));
        }
        return chatMessages;
    }

    @Override
    public void populateAllMessages() {
        messages = mRepo.findAll();
    }

    @Override
    public void save(Message message) {
        Message newMessage = mRepo.save(message);
        messages.add(newMessage);
    }
}
