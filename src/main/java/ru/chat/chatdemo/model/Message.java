package ru.chat.chatdemo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexpench on 17.02.17.
 */

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "message_sequence")
    @SequenceGenerator(name = "message_sequence", sequenceName = "message_seq")
    private long id = 0;

    @Column(name = "user_id")
    private long userId = 0;

    @Column(name = "chat_id")
    private long chatId = 0;
    private String text = "";
    private Date date = new Date();
    public Message() {}
    public Message(long userId, long chatId, String text, Date date) {
        this.userId = userId;
        this.chatId = chatId;
        this.text = text;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

