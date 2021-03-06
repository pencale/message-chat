package ru.chat.chatdemo.service;

import ru.chat.chatdemo.model.User;

import java.util.List;

/**
 * Created by alexpench on 18.02.17.
 */
public interface UserMapperService {
    User add(User user);
    List<User> getAllActiveUsers();
    User findOne(Long ownerId);
    void updateStatus(User user);
}
