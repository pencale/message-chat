package ru.chat.chatdemo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import ru.chat.chatdemo.model.Chat;
import ru.chat.chatdemo.model.Message;

import java.util.List;

/**
 * Created by alexpench on 17.02.17.
 */
public interface MessageRepository extends Repository<Message, Long> {
    Message save(Message message);
    List<Message> findAll();
}
