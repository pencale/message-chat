package ru.chat.chatdemo.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by alexpench on 17.02.17.
 */
@Entity
@Table(name = "chat_map")
public class Chat {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "chat_sequence")
    @SequenceGenerator(name = "chat_sequence", sequenceName = "chat_seq")
    private Long id = 0L;

    @Column(name = "user_ids")
    @Type(type = "ru.chat.chatdemo.service.CustomArrayType")
    private Long[] users;

    public Chat() {}

    public Chat(Long[] users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long[] getUsers() {
        return users;
    }

    public void setUsers(Long[] users) {
        this.users = users;
    }
}
