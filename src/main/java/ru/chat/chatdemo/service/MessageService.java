package ru.chat.chatdemo.service;

import ru.chat.chatdemo.model.Chat;
import ru.chat.chatdemo.model.Message;

import java.util.List;

/**
 * Created by alexpench on 19.02.17.
 */
public interface MessageService {
    List<Message> getMessagesForChat(Chat chat);
    void populateAllMessages();
    void save(Message message);
}
