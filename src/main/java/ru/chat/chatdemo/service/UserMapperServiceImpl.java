package ru.chat.chatdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.chat.chatdemo.model.User;
import ru.chat.chatdemo.model.repositories.UserRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * Created by alexpench on 18.02.17.
 */
@Component
public class UserMapperServiceImpl implements UserMapperService {
    private List<User> users = new LinkedList<>();
    @Autowired
    private UserRepository repo;

    @Override
    public User add(String name) {
        users = repo.findAll();

        for (User user : users) {
            if (user.getName().equals(name)) {
                user.setActive(true);
                repo.save(user);
                return user;
            }
        }

        User newUser = repo.save(new User(name));
        users.add(newUser);
        return newUser;
    }

    @Override
    public List<User> getAllActiveUsers() {
        List<User> activeusers = users
                .stream()
                .filter(u -> u.isActive())
                .collect(Collectors.toList());
        return activeusers;
    }

    @Override
    public User findOne(Long ownerId) {
        for (User user : users) {
            if(user.getId() == ownerId){
                return user;
            }
        }
        return repo.findOne(ownerId);
    }

    @Override
    public void updateStatus(User user) {
        users.remove(user);
        user.setActive(false);
        repo.save(user);

    }
}