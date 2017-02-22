package ru.chat.chatdemo.controllers;

/**
 * Created by alexpench on 19.02.17.
 */
public class ChatUsers {
    private Long ownerId = 0L;
    private Long userId = 0L;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ChatUsers() {}
    public ChatUsers(Long ownerId, Long userid) {

        this.ownerId = ownerId;
        this.userId = userid;
    }
}
