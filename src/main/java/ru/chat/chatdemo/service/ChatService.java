package ru.chat.chatdemo.service;

import ru.chat.chatdemo.model.Chat;

/**
 * Created by alexpench on 18.02.17.
 */
public interface ChatService {
    Chat addChat(Long[] users);
    Long getChatId(Long[] users);
    void loadAllChats();
}
