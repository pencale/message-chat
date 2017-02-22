package ru.chat.chatdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.chat.chatdemo.model.Chat;
import ru.chat.chatdemo.model.repositories.ChatMapRepository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexpench on 18.02.17.
 */
@Component
public class ChatServiceImpl implements ChatService {
    List<Chat> chats = new LinkedList<>();

    @Autowired
    private ChatMapRepository repo;

    @Override
    public Chat addChat(Long[] users) {
        loadAllChats();
        Arrays.sort(users);
        for (Chat chat : chats) {
            if(Arrays.equals(chat.getUsers(), users)){
                return chat;
            }
        }
        Chat newChat = repo.save(new Chat(users));
        chats.add(newChat);
        return newChat;
    }

    @Override
    public Long getChatId(Long[] users) {
        return null;
    }

    @Override
    public void loadAllChats() {
        chats = repo.findAll();
    }

}
