package ru.chat.chatdemo.model.repositories;

import org.springframework.data.repository.Repository;
import ru.chat.chatdemo.model.User;

import java.util.Deque;
import java.util.List;

/**
 * Created by alexpench on 18.02.17.
 */
public interface UserRepository extends Repository<User, Long> {
    User save(User user);
    List<User> findAll();
    User findOne(Long ownerId);
}