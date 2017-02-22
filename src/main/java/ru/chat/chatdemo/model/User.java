package ru.chat.chatdemo.model;

import javax.persistence.*;

/**
 * Created by alexpench on 17.02.17.
 */
@Entity
@Table(name="`user`")
public class User {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (active != user.active) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq")
    private long id = 0;
    private String name = "";
    private boolean active = false;

    public User() {}


    public User(String name) {
        this.name = name;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
